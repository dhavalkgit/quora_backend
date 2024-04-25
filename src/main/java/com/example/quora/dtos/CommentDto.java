package com.example.quora.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CommentDto {
    private Long userId;
    private String commentContent;
}
