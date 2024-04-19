package com.example.quora.services.Impl;

import com.example.quora.exceptionhandeler.ResourceNotFoundException;
import com.example.quora.models.Question;
import com.example.quora.models.User;
import com.example.quora.repository.QuestionRepo;
import com.example.quora.repository.UserRepo;
import com.example.quora.services.QuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo q_repo;
    private final UserRepo userRepo;

    public QuestionServiceImpl(QuestionRepo q_repo, UserRepo userRepo){
        this.q_repo=q_repo;
        this.userRepo=userRepo;
    }

    @Override
    public Question createQuestion(Question question, Long u_id) {
        User user = userRepo.findById(u_id).orElseThrow(()->new ResourceNotFoundException(u_id));
        question.setUser(user);
        System.out.println(question);
        return q_repo.save(question);
    }

    @Override
    public List<Question> searchQuestion(String keyword) {
        List<Question> byTitleLike = q_repo.findByTitleLike(keyword);
        for(Question q : byTitleLike){
            System.out.println(q.getUser().getName());
        }
        return byTitleLike;
    }
}

