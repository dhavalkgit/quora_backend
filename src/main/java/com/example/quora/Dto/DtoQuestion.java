package com.example.quora.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
public class DtoQuestion {
    private String title;

    private String body;

    private List<String>topic;

    private Long userId;
}
