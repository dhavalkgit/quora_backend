package com.example.quora.controller;

import com.example.quora.adapter.CommentDtoToCommentAdapter;
import com.example.quora.dtos.CommentDto;
import com.example.quora.models.Comment;
import com.example.quora.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;
    private final CommentDtoToCommentAdapter commentAdapter;

    public CommentController(CommentService commentService, CommentDtoToCommentAdapter commentAdapter) {
        this.commentService = commentService;
        this.commentAdapter=commentAdapter;
    }

    @PostMapping("/{answer_id}/answers")
    public ResponseEntity<?> postComment(@RequestBody CommentDto commentDto, @PathVariable Long answer_id){
        Comment comment = commentAdapter.commentDtoToComment(commentDto, answer_id);
        Comment res = commentService.createComment(comment);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/{parent_id}/comments")
    public ResponseEntity<?> replayOnComment(@RequestBody CommentDto commentDto, @PathVariable Long parent_id){
        Comment comment = commentAdapter.CommentToComment(commentDto, parent_id);
        Comment res = commentService.createComment(comment);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
