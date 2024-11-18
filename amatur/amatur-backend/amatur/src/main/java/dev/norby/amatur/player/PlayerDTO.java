package dev.norby.amatur.player;

import dev.norby.amatur.contest.ContestDTO;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PlayerDTO {
    private Integer id;
    private String name;
    private Set<ContestDTO> contests; // If you want to include contests for a player
}