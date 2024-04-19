package com.example.quora.services.Impl;

import com.example.quora.models.Answer;
import com.example.quora.models.Comment;
import com.example.quora.models.User;
import com.example.quora.repository.AnswerRepo;
import com.example.quora.repository.CommentRepo;
import com.example.quora.repository.UserRepo;
import com.example.quora.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final UserRepo userRepo;
    private final AnswerRepo answerRepo;
    private final CommentRepo commentRepo;

    public CommentServiceImpl(UserRepo userRepo, AnswerRepo answerRepo, CommentRepo commentRepo) {
        this.userRepo = userRepo;
        this.answerRepo = answerRepo;
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment createComment(Comment comment, Long answer_id, Long user_id) {
        Optional<User> user = userRepo.findById(user_id);
        Optional<Answer> answer = answerRepo.findById(answer_id);

        comment.setUser(user.get());
        comment.setAnswer(answer.get());

        return commentRepo.save(comment);
    }

    @Override
    public Comment createReplayOnComment(Comment comment, Long parent_id, Long user_id) {
        Optional<Comment> parent = commentRepo.findById(parent_id);
        Optional<User> user = userRepo.findById(user_id);
        if(parent.isPresent()){
            comment.setParentComment(parent.get());
            comment.setUser(user.get());
            return commentRepo.save(comment);
        }
        return null;
    }
}
