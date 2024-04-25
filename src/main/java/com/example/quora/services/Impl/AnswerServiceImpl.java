package com.example.quora.services.Impl;

import com.example.quora.models.Answer;
import com.example.quora.repository.AnswerRepo;
import com.example.quora.services.AnswerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepo answerRepo;

    public AnswerServiceImpl(AnswerRepo answerRepo){
        this.answerRepo=answerRepo;
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepo.save(answer);
    }

    @Override
    public Answer updateAnswer(String text, Long id) {
        Optional<Answer> oldAnswer = answerRepo.findById(id);
        oldAnswer.get().setText(text);
        return answerRepo.save(oldAnswer.get());
    }

    @Override
    public Answer getAnswerById(Long id) {
        Optional<Answer> byId = answerRepo.findById(id);
        return byId.orElse(null);
    }
}
