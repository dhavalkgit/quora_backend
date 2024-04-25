package com.example.quora.services.Impl;

import com.example.quora.models.*;
import com.example.quora.repository.AnswerLikeRepo;
import com.example.quora.repository.CommentLikeRepo;
import com.example.quora.repository.QuestionLikeRepo;
import com.example.quora.services.*;
import org.springframework.stereotype.Service;

@Service
public class LikeServiceImpl implements LikeService {
    private final QuestionLikeRepo questionLikeRepo;
    private final AnswerLikeRepo answerLikeRepo;
    private final CommentLikeRepo commentLikeRepo;
    private final UserServices userServices;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final CommentService commentService;

    public LikeServiceImpl(QuestionLikeRepo questionLikeRepo, AnswerLikeRepo answerLikeRepo,
                           CommentLikeRepo commentLikeRepo, UserServices userServices,
                           QuestionService questionService,
                           AnswerService answerService, CommentService commentService) {
        this.questionLikeRepo = questionLikeRepo;
        this.answerLikeRepo = answerLikeRepo;
        this.commentLikeRepo = commentLikeRepo;
        this.userServices = userServices;
        this.questionService = questionService;
        this.answerService = answerService;
        this.commentService = commentService;
    }

    @Override
    public boolean addLike(String type, Long typeId, Long userId) {
        User user = userServices.getUser(userId);

        switch (type) {
            case "question" -> {
                Question questionById = questionService.getQuestionById(typeId);
                QuestionLike questionLike = QuestionLike.builder()
                        .question(questionById)
                        .build();
                questionLike.setUser(user);
                QuestionLike save = questionLikeRepo.save(questionLike);
                return true;
            }
            case "answer" -> {
                Answer answer = answerService.getAnswerById(typeId);
                AnswerLike answerLike = AnswerLike.builder()
                        .answer(answer)
                        .build();
                answerLike.setUser(user);
                answerLikeRepo.save(answerLike);
                return true;
            }
            case "comment" -> {
                Comment comment = commentService.getCommentById(typeId);
                CommentLike commentLike = CommentLike.builder()
                        .comment(comment)
                        .build();
                commentLike.setUser(user);
                commentLikeRepo.save(commentLike);
                return true;
            }
        }
        return false;
    }
}
