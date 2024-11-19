package dev.norby.amatur.user;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User Not Found");
    }

}
