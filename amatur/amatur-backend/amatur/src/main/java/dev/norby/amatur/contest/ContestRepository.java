package dev.norby.amatur.contest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContestRepository extends JpaRepository<Contest, Integer> {

    // Optionally, add a custom query method if you need to find a Contest by name or other criteria
    Optional<Contest> findByName(String name);
}
