package com.example.quora.exceptionhandeler;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Long id){
        super("user with the id "+ id+" not exists");
    }
}
