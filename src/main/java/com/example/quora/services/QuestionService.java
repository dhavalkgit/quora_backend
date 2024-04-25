package com.example.quora.services;

import com.example.quora.dtos.DtoQuestion;
import com.example.quora.models.Question;

import java.util.List;

public interface QuestionService {
    public Question createQuestion(Question question);
    public List<Question> searchQuestion(String keyword);
    public Question getQuestionById(Long id);
}
