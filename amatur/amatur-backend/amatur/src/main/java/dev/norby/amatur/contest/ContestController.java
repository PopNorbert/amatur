package dev.norby.amatur.contest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/contests")
public class ContestController {
    private final ContestRepository contestRepository;

    public ContestController(ContestRepository contestRepository) {
        this.contestRepository = contestRepository;
    }

    // Get all contests
    @GetMapping("")
    public List<ContestDTO> getAll() {
        List<Contest> contests = contestRepository.findAll();
        return contests.stream()
                .map(contest -> new ContestDTO(contest)) // Convert each Contest to ContestDTO
                .collect(Collectors.toList()); // Collect into a List<ContestDTO>
    }


    // Get a contest by ID
    @GetMapping("/{id}")
    ContestDTO getContest(@PathVariable Integer id) {
        Contest contest =  contestRepository.findById(id)
                .orElseThrow(ContestNotFoundException::new);
        return new ContestDTO(contest);
    }

    // Create a new contest
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Contest createContest(@Valid @RequestBody Contest contest) {
        return contestRepository.save(contest);
    }

    // Update an existing contest
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void updateContest(@PathVariable Integer id, @Valid @RequestBody Contest contest) {
        if (!contestRepository.existsById(id)) {
            throw new ContestNotFoundException();
        }
        contest.setId(id);
        contestRepository.save(contest);
    }

    // Delete a contest by ID
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteContest(@PathVariable Integer id) {
        if (!contestRepository.existsById(id)) {
            throw new ContestNotFoundException();
        }
        contestRepository.deleteById(id);
    }
}
