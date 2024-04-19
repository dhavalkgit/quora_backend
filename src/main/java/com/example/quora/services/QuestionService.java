package com.example.quora.services;

import com.example.quora.Dto.DtoQuestion;
import com.example.quora.models.Question;

import java.util.List;

public interface QuestionService {
    public Question createQuestion(DtoQuestion dtoQuestion);
    public List<Question> searchQuestion(String keyword);
}
