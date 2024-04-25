package com.example.quora.adapter;

import com.example.quora.dtos.CommentDto;
import com.example.quora.models.Comment;

public interface CommentDtoToCommentAdapter {
    public Comment commentDtoToComment(CommentDto commentDto, Long answerId);
    public Comment CommentToComment(CommentDto commentDto, Long commentId);
}
