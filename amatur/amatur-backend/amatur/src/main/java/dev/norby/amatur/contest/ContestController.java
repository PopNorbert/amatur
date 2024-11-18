package dev.norby.amatur.contest;

import dev.norby.amatur.match.MatchDTO;
import dev.norby.amatur.player.PlayerDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contests")
public class ContestController {
    private final ContestService contestService;

    public ContestController(ContestService contestService) {
        this.contestService = contestService;
    }

    // Get all contests
    @GetMapping("")
    public List<ContestDTO> findAll() {
        return contestService.findAll();
    }


    // Get a contest by ID
    @GetMapping("/{id}")
    ContestDTO findById(@PathVariable Integer id) {
        return contestService.findById(id);
    }

    @GetMapping("/{id}/players")
    List<PlayerDTO> findPlayers(@PathVariable Integer id){
        return contestService.findPlayers(id);
    }
    @GetMapping("/{id}/matches")
    List<MatchDTO> findMatches(@PathVariable Integer id){
        return contestService.findMatches(id);
    }

}

//    // Create a new contest
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("")
//    Contest createContest(@Valid @RequestBody Contest contest) {
//        return contestRepository.save(contest);
//    }
//
//    // Update an existing contest
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}")
//    void updateContest(@PathVariable Integer id, @Valid @RequestBody Contest contest) {
//        if (!contestRepository.existsById(id)) {
//            throw new ContestNotFoundException();
//        }
//        contest.setId(id);
//        contestRepository.save(contest);
//    }
//
//    // Delete a contest by ID
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    void deleteContest(@PathVariable Integer id) {
//        if (!contestRepository.existsById(id)) {
//            throw new ContestNotFoundException();
//        }
//        contestRepository.deleteById(id);
//    }
//}
