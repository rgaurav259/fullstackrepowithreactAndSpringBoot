package com.example.fullstack.fullstackbackend.exception;

public class UserNotFounException extends RuntimeException{
    public UserNotFounException(Long id) {
        super("not found the user  id: " + id);
    }
}
