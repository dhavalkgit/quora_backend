package com.example.quora.services.Impl;

import com.example.quora.models.Comment;
import com.example.quora.repository.CommentRepo;
import com.example.quora.repository.UserRepo;
import com.example.quora.services.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    private final UserRepo userRepo;
    private final CommentRepo commentRepo;

    public CommentServiceImpl(UserRepo userRepo, CommentRepo commentRepo) {
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepo.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
       return commentRepo.findById(id).orElse(null);
    }
}
