package com.example.quora.helper;

import com.example.quora.dtos.UserResponseDto;
import com.example.quora.models.User;

public interface UserHelper {
    public UserResponseDto sendUserResponse(User user);
}
