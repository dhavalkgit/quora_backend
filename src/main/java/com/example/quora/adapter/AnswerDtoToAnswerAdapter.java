package com.example.quora.adapter;

import com.example.quora.dtos.AnswerDto;
import com.example.quora.models.Answer;

public interface AnswerDtoToAnswerAdapter {
    public Answer AnswerDtoToAnswer(AnswerDto answerDto, Long question_id);
}
