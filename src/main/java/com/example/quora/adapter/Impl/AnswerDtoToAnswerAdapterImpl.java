package com.example.quora.adapter.Impl;

import com.example.quora.adapter.AnswerDtoToAnswerAdapter;
import com.example.quora.dtos.AnswerDto;
import com.example.quora.models.Answer;
import com.example.quora.models.Question;
import com.example.quora.models.User;
import com.example.quora.services.QuestionService;
import com.example.quora.services.UserServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class AnswerDtoToAnswerAdapterImpl implements AnswerDtoToAnswerAdapter {

    private final UserServices userServices;
    private final QuestionService questionService;

    public AnswerDtoToAnswerAdapterImpl(UserServices userServices, QuestionService questionService){
        this.userServices=userServices;
        this.questionService=questionService;
    }

    @Override
    public Answer AnswerDtoToAnswer(AnswerDto answerDto, Long question_id) {
        User user = userServices.getUser(answerDto.getUserId());
        Question question = questionService.getQuestionById(question_id);
        return Answer.builder()
                .text(answerDto.getText())
                .user(user)
                .question(question)
                .build();
    }
}
