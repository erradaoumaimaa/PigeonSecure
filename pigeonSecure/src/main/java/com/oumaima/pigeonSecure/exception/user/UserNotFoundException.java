package com.oumaima.pigeonSecure.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String detail) {
        super("User not found: " + detail);
    }
}
