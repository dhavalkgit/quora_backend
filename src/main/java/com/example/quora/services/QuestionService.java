package com.example.quora.services;

import com.example.quora.models.Question;

import java.util.List;

public interface QuestionService {
    public Question createQuestion(Question question, Long u_id);
    public List<Question> searchQuestion(String keyword);
}
