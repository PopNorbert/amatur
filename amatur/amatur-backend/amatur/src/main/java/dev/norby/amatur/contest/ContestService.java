package dev.norby.amatur.contest;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import dev.norby.amatur.player.Player;

@Service
@AllArgsConstructor
public class ContestService {
    private final ContestRepository contestRepository;

    public ContestDTO getContestWithPlayers(Integer contestId) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(() -> new RuntimeException("Contest not found"));

        Set<String> playerNames = contest.getPlayers()
                .stream()
                .map(Player::getName)
                .collect(Collectors.toSet());

        return new ContestDTO(contest.getId(), contest.getName(), contest.getPlayerLimit(), playerNames);
    }
}
