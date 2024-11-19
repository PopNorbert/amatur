package dev.norby.amatur.match;

import dev.norby.amatur.user.User;
import dev.norby.amatur.contest.Contest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User leftUser;

    @ManyToOne
    private User rightUser;

    @ManyToOne
    private Contest contest;

    @Builder.Default
    private Integer leftScore = 0;

    @Builder.Default
    private Integer rightScore = 0;


}
