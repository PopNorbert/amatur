package dev.norby.amatur.contest;

import dev.norby.amatur.player.PlayerDTO;
import lombok.AllArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ContestDTO {
    private Integer id;
    private String name;
    private Integer playerLimit;
    private Set<PlayerDTO> players;
}
