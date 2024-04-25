package com.example.quora.services;

import com.example.quora.models.Answer;

public interface AnswerService {
    public Answer createAnswer(Answer answer);
    public Answer updateAnswer(String text, Long id);
    public Answer getAnswerById(Long id);
}
