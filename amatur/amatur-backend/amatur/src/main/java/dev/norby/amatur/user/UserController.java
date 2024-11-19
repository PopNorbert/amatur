package dev.norby.amatur.user;

import dev.norby.amatur.contest.ContestDTO;
import dev.norby.amatur.match.MatchDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    // Get all users
    @GetMapping("")
    List<UserDTO> findAll() {
        return userService.findAll();
    }

    // Get a user by ID
    @GetMapping("/{id}")
    UserDTO findById(@PathVariable Integer id) {
        return userService.findById(id);
    }
    @GetMapping("/{id}/contests")
    List<ContestDTO> findContests(@PathVariable Integer id){
        return userService.findContests(id);
    }
    @GetMapping("/{id}/matches")
    List<MatchDTO> findMatches(@PathVariable Integer id)
    {
        return userService.findMatches(id);
    }

    // Delete a user by ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteContest(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
