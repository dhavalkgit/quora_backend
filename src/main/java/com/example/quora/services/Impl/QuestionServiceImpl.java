package com.example.quora.services.Impl;

import com.example.quora.models.Question;
import com.example.quora.repository.QuestionRepo;
import com.example.quora.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo q_repo;

    public QuestionServiceImpl(QuestionRepo q_repo){
        this.q_repo=q_repo;
    }

    @Override
    public Question createQuestion(Question question) {
        return q_repo.save(question);
    }

    @Override
    public List<Question> searchQuestion(String keyword) {
        List<Question> question = q_repo.findAllByTitleContaining(keyword);
        for (Question q : question){
            System.out.println(q.getTopics().size());
        }
        return question;
    }

    @Override
    public Question getQuestionById(Long id) {
        Optional<Question> question = q_repo.findById(id);
        return question.orElse(null);
    }
}