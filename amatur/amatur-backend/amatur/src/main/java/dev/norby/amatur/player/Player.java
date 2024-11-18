package dev.norby.amatur.player;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.norby.amatur.contest.Contest;
import dev.norby.amatur.match.Match;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "players")
    @JsonBackReference
    @Builder.Default
    private Set<Contest> contests = new HashSet<>();

    @OneToMany(mappedBy = "leftPlayer")
    private Set<Match> matchesLeft = new HashSet<>();

    @OneToMany(mappedBy = "rightPlayer")
    private Set<Match> matchesRight = new HashSet<>();

    public Set<Match> getMatches(){
        Set<Match> res = new HashSet<>(matchesLeft);
        res.addAll(matchesRight);
        return res;
    }

}
