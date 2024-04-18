package com.example.quora.exceptionhandeler;

public class ResourceDuplicateException extends RuntimeException{
    String userName;
    public ResourceDuplicateException(String userName){
        super("User is already present with a user name: "+ userName);
    }
}
