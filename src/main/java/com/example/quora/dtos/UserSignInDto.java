package com.example.quora.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignInDto {
    private String email;
    private String password;
}
