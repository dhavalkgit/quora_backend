package com.example.quora.adapter;

import com.example.quora.dtos.DtoQuestion;
import com.example.quora.models.Question;

public interface DtoQuestionToQuestionAdapter {
    public Question dtoQuestionToQuestion(DtoQuestion dtoQuestion);
}
