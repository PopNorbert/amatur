package dev.norby.amatur;

import dev.norby.amatur.contest.ContestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(ContestRepository contestRepository) {
        return args -> {
            //Contest contest = new Contest(2, "C5");
            //contestRepository.createContest(contest);
        };
    }

}
