package com.example.quora.services;

import com.example.quora.models.Comment;

public interface CommentService {
    public Comment createComment(Comment comment);
    public Comment getCommentById(Long id);
}
