package dev.norby.amatur.contest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ContestNotFoundException extends RuntimeException {
    public ContestNotFoundException() {
        super("Contest Not Found");
    }
}
