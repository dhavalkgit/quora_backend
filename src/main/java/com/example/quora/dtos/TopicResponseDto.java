package com.example.quora.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicResponseDto {
    private Long id;

    private String topicName;
}
