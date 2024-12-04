package dev.norby.amatur.contest;

import dev.norby.amatur.match.MatchDTO;
import dev.norby.amatur.match.MatchMapper;
import dev.norby.amatur.user.*;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ContestService {
    private final ContestRepository contestRepository;
    private final UserMapper userMapper;
    private final ContestMapper contestMapper;
    private final MatchMapper matchMapper;
    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public ContestDTO findById(Integer contestId) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(ContestNotFoundException::new);

        return contestMapper.toDTO(contest);
    }

    public List<ContestDTO> findAll() {
        return contestRepository.findAll()
                .stream()
                .map(contestMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<UserDTO> findUsers(Integer contestId) {
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(ContestNotFoundException::new);
        return contest.getUsers()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
    public List<MatchDTO> findMatches(Integer contestId){
        Contest contest = contestRepository.findById(contestId)
                .orElseThrow(ContestNotFoundException::new);
        return contest.getMatches()
                .stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }
    public ContestDTO save(ContestDTO contestDTO){
        Contest contest = contestRepository.save(contestMapper.toEntity(contestDTO));
        return contestMapper.toDTO(contest);
    }

    public void deleteById(Integer id) {
        if (!contestRepository.existsById(id)){
            throw new ContestNotFoundException();
        }
        contestRepository.deleteById(id);
    }

    public ContestDTO updateContest(Integer id, ContestDTO contestDTO) {
        Contest contest = contestRepository.findById(id)
                .orElseThrow(ContestNotFoundException::new);

        // Update fields
        contest.setName(contestDTO.name());
        contest.setUserLimit(contestDTO.userLimit());

        // Save and return updated DTO
        Contest updatedContest = contestRepository.save(contest);
        return contestMapper.toDTO(updatedContest);
    }

    public void joinContest(Integer id) {
        Contest contest = contestRepository.findById(id)
                .orElseThrow(ContestNotFoundException::new);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        contest.addUser(user);
        contestRepository.save(contest);
    }
}
