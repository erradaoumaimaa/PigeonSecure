package com.oumaima.pigeonSecure.exception.user;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String username){
        super("The username '" + username + "' already exists.");
    }
}
