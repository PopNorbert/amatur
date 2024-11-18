package dev.norby.amatur.player;

import dev.norby.amatur.contest.ContestDTO;
import dev.norby.amatur.match.MatchDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerService playerService;

    // Get all players
    @GetMapping("")
    List<PlayerDTO> findAll() {
        return playerService.findAll();
    }

    // Get a player by ID
    @GetMapping("/{id}")
    PlayerDTO findById(@PathVariable Integer id) {
        return playerService.findById(id);
    }
    @GetMapping("/{id}/contests")
    List<ContestDTO> findContests(@PathVariable Integer id){
        return playerService.findContests(id);
    }
    @GetMapping("/{id}/matches")
    List<MatchDTO> findMatches(@PathVariable Integer id)
    {
        return playerService.findMatches(id);
    }
}

//    // Create a new player
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("")
//    Player createPlayer(@Valid @RequestBody Player player) {
//        return playerRepository.save(player);
//    }
//
//    // Update an existing player
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}")
//    void updatePlayer(@PathVariable Integer id, @Valid @RequestBody Player player) {
//        if (!playerRepository.existsById(id)) {
//            throw new PlayerNotFoundException();
//        }
//        player.setId(id);
//        playerRepository.save(player);
//    }
//
//    // Delete a player by ID
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    void deletePlayer(@PathVariable Integer id) {
//        if (!playerRepository.existsById(id)) {
//            throw new PlayerNotFoundException();
//        }
//        playerRepository.deleteById(id);
//    }
//}
