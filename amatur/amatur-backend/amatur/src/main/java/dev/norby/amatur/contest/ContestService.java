package dev.norby.amatur.contest;

import dev.norby.amatur.match.MatchDTO;
import dev.norby.amatur.player.PlayerDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import dev.norby.amatur.player.Player;

@Service
@AllArgsConstructor
public class ContestService {
    private final ContestRepository contestRepository;

    public ContestDTO findById(Integer contestId) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(() -> new RuntimeException("Contest not found"));

        return new ContestDTO(contest.getId(), contest.getName(), contest.getPlayerLimit());
    }

    public List<ContestDTO> findAll() {
        return contestRepository.findAll()
                .stream()
                .map(contest -> new ContestDTO(contest.getId(), contest.getName(), contest.getPlayerLimit()))
                .collect(Collectors.toList());
    }

    public List<PlayerDTO> findPlayers(Integer contestId) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(ContestNotFoundException::new);
        return contest.getPlayers()
                .stream()
                .map(player -> new PlayerDTO(player.getId(), player.getName()))
                .collect(Collectors.toList());
    }
    public List<MatchDTO> findMatches(Integer contestId){
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(ContestNotFoundException::new);
        return contest.getMatches()
                .stream()
                .map(match -> new MatchDTO(match.getId(), match.getLeftScore(), match.getRightScore()))
                .collect(Collectors.toList());
    }
}
