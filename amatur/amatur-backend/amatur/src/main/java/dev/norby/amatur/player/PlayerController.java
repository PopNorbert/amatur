package dev.norby.amatur.player;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Get all players
    @GetMapping("")
    List<PlayerDTO> getAll() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .map(player -> new PlayerDTO(player))
                .collect(Collectors.toList());
    }

    // Get a player by ID
    @GetMapping("/{id}")
    PlayerDTO getPlayer(@PathVariable Integer id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(()->new PlayerNotFoundException());
        return new PlayerDTO(player);

    }

    // Create a new player
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Player createPlayer(@Valid @RequestBody Player player) {
        return playerRepository.save(player);
    }

    // Update an existing player
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updatePlayer(@PathVariable Integer id, @Valid @RequestBody Player player) {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotFoundException();
        }
        player.setId(id);
        playerRepository.save(player);
    }

    // Delete a player by ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deletePlayer(@PathVariable Integer id) {
        if (!playerRepository.existsById(id)) {
            throw new PlayerNotFoundException();
        }
        playerRepository.deleteById(id);
    }
}
