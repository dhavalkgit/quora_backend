package com.example.quora.helper;

import com.example.quora.dtos.TopicResponseDto;
import com.example.quora.models.Topics;

public interface TopicHelper {
    public TopicResponseDto sendTopicResponse(Topics topics);
}
