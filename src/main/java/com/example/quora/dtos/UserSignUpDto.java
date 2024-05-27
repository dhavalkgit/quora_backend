package com.example.quora.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpDto {
    private String name;
    private String email;
    private String password;
    private String about;
}
