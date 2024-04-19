package com.example.quora.services.Impl;

import com.example.quora.exceptionhandeler.ResourceNotFoundException;
import com.example.quora.models.Answer;
import com.example.quora.models.Question;
import com.example.quora.models.User;
import com.example.quora.repository.AnswerRepo;
import com.example.quora.repository.QuestionRepo;
import com.example.quora.repository.UserRepo;
import com.example.quora.services.AnswerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepo answerRepo;
    private final UserRepo userRepo;
    private final QuestionRepo questionRepo;

    public AnswerServiceImpl(AnswerRepo answerRepo, UserRepo userRepo, QuestionRepo questionRepo){
        this.answerRepo=answerRepo;
        this.userRepo=userRepo;
        this.questionRepo=questionRepo;
    }

    @Override
    public Answer createAnswer(Answer answer, Long question_id, Long user_id) {
        Question question = questionRepo.findById(question_id)
                .orElseThrow(()->new ResourceNotFoundException(question_id));
        User user = userRepo.findById(user_id)
                .orElseThrow(()->new ResourceNotFoundException(user_id));
        answer.setQuestion(question);
        answer.setUser(user);
        return answerRepo.save(answer);
    }

    @Override
    public Answer updateAnswer(Answer answer, Long id) {
        Optional<Answer> oldAnswer = answerRepo.findById(id);
        oldAnswer.get().setText(answer.getText());
        return answerRepo.save(oldAnswer.get());
    }
}
