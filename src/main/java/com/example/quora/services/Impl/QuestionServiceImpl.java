package com.example.quora.services.Impl;

import com.example.quora.Dto.DtoQuestion;
import com.example.quora.exceptionhandeler.ResourceNotFoundException;
import com.example.quora.models.Question;
import com.example.quora.models.Topics;
import com.example.quora.models.User;
import com.example.quora.repository.QuestionRepo;
import com.example.quora.repository.UserRepo;
import com.example.quora.services.QuestionService;
import com.example.quora.services.TopicsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepo q_repo;
    private final UserRepo userRepo;
    private final TopicsService topicsService;

    public QuestionServiceImpl(QuestionRepo q_repo, UserRepo userRepo, TopicsService topicsService){
        this.q_repo=q_repo;
        this.userRepo=userRepo;
        this.topicsService=topicsService;
    }

    @Override
    public Question createQuestion(DtoQuestion dtoQuestion) {
        User user = userRepo.findById(dtoQuestion.getUserId()).orElseThrow(
                ()->new ResourceNotFoundException(dtoQuestion.getUserId()));
        List<Topics> topics = new ArrayList<>();
        for(String tag : dtoQuestion.getTopic()){
            topics.add(topicsService.getSingleTopic(tag));
        }

        Question question = Question.builder()
                .title(dtoQuestion.getTitle())
                .body(dtoQuestion.getBody())
                .user(user)
                .topics(topics)
                .build();

        return  q_repo.save(question);
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

