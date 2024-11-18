package dev.norby.amatur.contest;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import dev.norby.amatur.player.Player;

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
public class Contest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer playerLimit;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "contest_player",
            joinColumns = @JoinColumn(name = "contest_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    @JsonManagedReference
    @Builder.Default
    private Set<Player> players = new HashSet<>();

    public void addPlayer(Player player)
    {
        if(players.size()>=playerLimit){
            throw new IllegalStateException("contest full");
        }
        players.add(player);
        player.getContests().add(this);
    }

}
