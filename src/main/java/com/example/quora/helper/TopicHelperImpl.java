package com.example.quora.helper;

import com.example.quora.dtos.TopicResponseDto;
import com.example.quora.models.Topics;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class TopicHelperImpl implements TopicHelper{
    @Override
    public TopicResponseDto sendTopicResponse(Topics topics) {
        return TopicResponseDto.builder()
                .topicName(topics.getTopicName())
                .id(topics.getId())
                .build();
    }
}
