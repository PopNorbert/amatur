package dev.norby.amatur.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.norby.amatur.contest.Contest;
import dev.norby.amatur.match.Match;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String username;

    @Column
    private String password;

    @Enumerated(value=EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "users")
    @JsonIgnore
    @Builder.Default
    private Set<Contest> contests = new HashSet<>();

    @OneToMany(mappedBy = "leftUser")
    private Set<Match> matchesLeft = new HashSet<>();

    @OneToMany(mappedBy = "rightUser")
    private Set<Match> matchesRight = new HashSet<>();

    public Set<Match> getMatches(){
        Set<Match> res = new HashSet<>(matchesLeft);
        res.addAll(matchesRight);
        return res;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
