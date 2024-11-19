package dev.norby.amatur.authentication;

import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }
}
