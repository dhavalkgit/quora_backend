package com.example.quora.services;

import com.example.quora.dtos.UserSignUpDto;
import com.example.quora.models.User;

import java.util.List;

public interface UserServices {
    public User createUser(UserSignUpDto user);
    public User updateUser(User newUserData, Long id);
    public User getByUserName(String username);
    public User getUser(Long id);
    public List<User> getAllUsers();
    public boolean addFollow(Long userId, Long targetUserId);
}
