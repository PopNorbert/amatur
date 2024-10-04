package dev.norby.amatur.player;

import jakarta.validation.constraints.NotEmpty;

public record Player(
        Integer id,
        @NotEmpty
        String name
) {
}
