package dev.norby.amatur.contest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class ContestRepository {
    private static final Logger log = LoggerFactory.getLogger(ContestRepository.class);
    private final JdbcClient jdbcClient;

    public ContestRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Contest> readAll() {
        return jdbcClient.sql("select * from contest")
                .query(Contest.class)
                .list();
    }

    public Optional<Contest> readContest(Integer id) {
        return jdbcClient.sql("select id,name from contest where id = :id")
                .param("id", id)
                .query(Contest.class)
                .optional();
    }

    public void deleteContest(Integer id) {
        var updated = jdbcClient.sql("delete from contest where id = :id")
                .param("id", id)
                .update();
        Assert.state(updated == 1, "Failed to delete contest " + id);
    }

    public void updateContest(Integer id, Contest contest) {
        var updated = jdbcClient.sql("update contest set name = :name where id = :id")
                .param("id", id)
                .param("name", contest.name())
                .update();
        Assert.state(updated == 1, "Failed to update contest " + id);
    }

    public void createContest(Contest contest) {
        var updated = jdbcClient.sql("insert into contest(id,name) values(:id,:name)")
                .param("id", contest.id())
                .param("name", contest.name())
                .update();
        Assert.state(updated == 1, "Failed to create contest");

    }
}
