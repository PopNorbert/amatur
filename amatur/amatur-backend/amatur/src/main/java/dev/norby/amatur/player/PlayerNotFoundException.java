package dev.norby.amatur.player;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException() {
        super("Player Not Found");
    }

}
