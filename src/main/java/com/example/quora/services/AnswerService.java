package com.example.quora.services;

import com.example.quora.models.Answer;

public interface AnswerService {
    public Answer createAnswer(Answer answer, Long question_id, Long user_id);
    public Answer updateAnswer(Answer answer, Long id);
}
