package dev.norby.amatur.contest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.norby.amatur.match.Match;
import jakarta.persistence.*;
import lombok.*;
import dev.norby.amatur.user.User;

import java.util.HashSet;
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
    private Integer userLimit;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "contest_users",
            joinColumns = @JoinColumn(name = "contest_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id")
    )
    @JsonIgnore
    @Builder.Default
    private Set<User> users = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "contest", cascade = CascadeType.PERSIST)
    private Set<Match> matches = new HashSet<>();


    public void addUser(User user)
    {
        if(users.size()>=userLimit){
            throw new IllegalStateException("contest full");
        }
        users.add(user);
        user.getContests().add(this);
    }

}
