package com.example.quora.services;

import com.example.quora.models.User;

import java.util.List;

public interface UserServices {
    public User createUser(User user);
    public User updateUser(User newUserData, Long id);
    public User getUser(Long id);
    public List<User> getAllUsers();
}
