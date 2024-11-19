package dev.norby.amatur.user;

import dev.norby.amatur.contest.ContestDTO;
import dev.norby.amatur.contest.ContestMapper;
import dev.norby.amatur.match.MatchDTO;
import dev.norby.amatur.match.MatchMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ContestMapper contestMapper;
    private final MatchMapper matchMapper;

    public UserDTO findById(Integer id){
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        return userMapper.toDTO(user);
    }
    public List<UserDTO> findAll(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
    public List<ContestDTO> findContests(Integer userId){
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return user.getContests()
                .stream()
                .map(contestMapper::toDTO)
                .collect(Collectors.toList());

    }
    public List<MatchDTO> findMatches(Integer userId){
        User user = userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
        return user.getMatches()
                .stream()
                .map(matchMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }
}
