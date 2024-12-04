package com.oumaima.pigeonSecure.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("The username '" + username + "' not found.");
    }
}
