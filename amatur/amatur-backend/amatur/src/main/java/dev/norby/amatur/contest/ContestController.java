package dev.norby.amatur.contest;

import dev.norby.amatur.match.MatchDTO;
import dev.norby.amatur.user.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/join")
    void joinContest(@PathVariable Integer id){
        contestService.joinContest(id);
    }

    @GetMapping("/{id}/users")
    List<UserDTO> findUsers(@PathVariable Integer id){
        return contestService.findUsers(id);
    }
    @GetMapping("/{id}/matches")
    List<MatchDTO> findMatches(@PathVariable Integer id){
        return contestService.findMatches(id);
    }

    // Create a new contest
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    ContestDTO createContest(@Valid @RequestBody ContestDTO contest) {
        return contestService.save(contest);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    ContestDTO updateContest(@PathVariable Integer id, @Valid @RequestBody ContestDTO contest) {
        return contestService.updateContest(id, contest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteContest(@PathVariable Integer id) {
        contestService.deleteById(id);
    }
}
