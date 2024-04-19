package com.example.quora.services;

import com.example.quora.models.Comment;

public interface CommentService {
    public Comment createComment(Comment comment, Long answer_id, Long user_id);
    public default Comment createReplayOnComment(Comment comment, Long parent_id, Long user_id){
        return null;
    }
}
