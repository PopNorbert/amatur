package dev.norby.amatur.contest;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

public record Contest(
        @Id
        Integer id,
        @NotEmpty
        String name
) {

}
