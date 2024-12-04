package dev.norby.amatur;

import dev.norby.amatur.contest.Contest;
import dev.norby.amatur.contest.ContestRepository;
import dev.norby.amatur.match.Match;
import dev.norby.amatur.user.Role;
import dev.norby.amatur.user.User;
import dev.norby.amatur.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
    @Bean
    CommandLineRunner runner(ContestRepository contestRepository, UserRepository userRepository) {
        return args -> {
            BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
            User user1 = User.builder()
                            .firstname("U1")
                                    .lastname("U1")
                                            .username("U1")
                                                    .password(enc.encode("U1"))
                                                            .role(Role.HOST).build();
            User user2 = User.builder()
                    .firstname("U2")
                    .lastname("U2")
                    .username("U2")
                    .password(enc.encode("U2"))
                    .role(Role.USER).build();

            User user3 = User.builder()
                    .firstname("U3")
                    .lastname("U3")
                    .username("U3")
                    .password(enc.encode("U3"))
                    .role(Role.USER).build();

            Contest contest1 = Contest.builder()
                    .name("Contest 1")
                    .userLimit(4)
                    .build();

            contest1.addUser(user2);
            userRepository.save(user1);
            contestRepository.save(contest1);
            userRepository.save(user3);
        };
    }

}
