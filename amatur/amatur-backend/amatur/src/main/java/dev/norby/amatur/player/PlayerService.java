package dev.norby.amatur.player;

import dev.norby.amatur.contest.ContestDTO;
import dev.norby.amatur.match.MatchDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerDTO findById(Integer id){
        Player player = playerRepository.findById(id).orElseThrow(PlayerNotFoundException::new);
        return new PlayerDTO(player.getId(), player.getName());
    }
    public List<PlayerDTO> findAll(){
        return playerRepository.findAll()
                .stream()
                .map(player -> new PlayerDTO(player.getId(), player.getName()))
                .collect(Collectors.toList());
    }
    public List<ContestDTO> findContests(Integer playerId){
        Player player = playerRepository.findById(playerId).orElseThrow(PlayerNotFoundException::new);
        return player.getContests()
                .stream()
                .map(contest -> new ContestDTO(contest.getId(), contest.getName(), contest.getPlayerLimit()))
                .collect(Collectors.toList());

    }
    public List<MatchDTO> findMatches(Integer playerId){
        Player player = playerRepository.findById(playerId).orElseThrow(PlayerNotFoundException::new);
        return player.getMatches()
                .stream()
                .map(match -> new MatchDTO(match.getId(), match.getLeftScore(), match.getRightScore()))
                .collect(Collectors.toList());
    }
}
