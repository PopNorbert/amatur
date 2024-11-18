package dev.norby.amatur;

import dev.norby.amatur.contest.Contest;
import dev.norby.amatur.contest.ContestRepository;
import dev.norby.amatur.player.Player;
import dev.norby.amatur.player.PlayerController;
import dev.norby.amatur.player.PlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.tokens.CommentToken;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner runner(ContestRepository contestRepository, PlayerRepository playerRepository) {
        return args -> {
            Player player1 = Player.builder().name("P1").build();

            Contest contest1 = Contest.builder()
                    .name("Contest 1")
                    .playerLimit(2)
                    .build();

            contest1.addPlayer(player1);
            contestRepository.save(contest1);
        };
    }

}
