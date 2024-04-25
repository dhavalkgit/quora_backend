package com.example.quora.adapter.Impl;

import com.example.quora.adapter.DtoQuestionToQuestionAdapter;
import com.example.quora.dtos.DtoQuestion;
import com.example.quora.models.Question;
import com.example.quora.models.Topics;
import com.example.quora.models.User;
import com.example.quora.services.TopicsService;
import com.example.quora.services.UserServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
public class DtoQuestionToQuestionAdapterImpl implements DtoQuestionToQuestionAdapter {

    private final UserServices userServices;
    private final TopicsService topicsService;

    public DtoQuestionToQuestionAdapterImpl(UserServices userServices, TopicsService topicsService){
        this.userServices=userServices;
        this.topicsService=topicsService;
    }

    @Override
    public Question dtoQuestionToQuestion(DtoQuestion dtoQuestion) {
        List<Topics> topics = new ArrayList<>();

        User user = userServices.getUser(dtoQuestion.getUserId());

        for(String tag : dtoQuestion.getTopic()){
            topics.add(topicsService.getSingleTopic(tag));
        }

        return Question.builder()
                .title(dtoQuestion.getTitle())
                .body(dtoQuestion.getBody())
                .user(user)
                .topics(topics)
                .build();
    }
}
