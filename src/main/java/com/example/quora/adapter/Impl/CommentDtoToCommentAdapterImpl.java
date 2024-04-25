package com.example.quora.adapter.Impl;

import com.example.quora.adapter.CommentDtoToCommentAdapter;
import com.example.quora.dtos.CommentDto;
import com.example.quora.models.Answer;
import com.example.quora.models.Comment;
import com.example.quora.models.User;
import com.example.quora.services.AnswerService;
import com.example.quora.services.CommentService;
import com.example.quora.services.UserServices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class CommentDtoToCommentAdapterImpl implements CommentDtoToCommentAdapter {

    private final UserServices userServices;
    private final AnswerService answerService;
    private final CommentService commentService;

    public CommentDtoToCommentAdapterImpl(UserServices userServices, AnswerService answerService,
                                          CommentService commentService) {
        this.userServices = userServices;
        this.answerService = answerService;
        this.commentService = commentService;
    }

    @Override
    public Comment commentDtoToComment(CommentDto commentDto, Long answerId) {
        User user = userServices.getUser(commentDto.getUserId());
        Answer answer = answerService.getAnswerById(answerId);

        return Comment.builder()
                .answer(answer)
                .user(user)
                .content(commentDto.getCommentContent())
                .build();
    }

    @Override
    public Comment CommentToComment(CommentDto commentDto, Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        User user = userServices.getUser(commentDto.getUserId());
        return Comment.builder()
                .user(user)
                .parentComment(comment)
                .content(commentDto.getCommentContent())
                .build();
    }
}
