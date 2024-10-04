package dev.norby.amatur.contest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contests")
public class ContestController {
    private final ContestRepository contestRepository;

    public ContestController(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    @GetMapping("")
    List<Contest> getAll() {
        return contestRepository.readAll();
    }

    @GetMapping("/{id}")
    Contest getContest(@PathVariable Integer id) {
        Optional<Contest> contest = contestRepository.readContest(id);
        if (contest.isEmpty()) {
            throw new ContestNotFoundException();
        }
        return contest.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createContest(@Valid @RequestBody Contest contest) {
        contestRepository.createContest(contest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateContest(@PathVariable Integer id, @RequestBody Contest contest) {
        contestRepository.updateContest(id, contest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteContest(@PathVariable Integer id) {
        contestRepository.deleteContest(id);
    }


}
