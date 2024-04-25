package com.example.quora.helper;

import com.example.quora.dtos.UserResponseDto;
import com.example.quora.models.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class userHelperImpl implements UserHelper{
    @Override
    public UserResponseDto sendUserResponse(User user) {
        return UserResponseDto.builder()
                .about(user.getAbout())
                .email(user.getEmail())
                .id(user.getId())
                .name(user.getName())
                .build();
    }
}
