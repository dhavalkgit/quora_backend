package com.example.quora.controller;

import com.example.quora.models.Comment;
import com.example.quora.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/answers/{answer_id}/users/{user_id}")
    public ResponseEntity<?> postComment(@RequestBody Comment comment, @PathVariable Long answer_id,
                                         @PathVariable Long user_id){
        Comment res = commentService.createComment(comment,answer_id,user_id);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/{parent_id}/users/{user_id}")
    public ResponseEntity<?> replayOnComment(@RequestBody Comment comment, @PathVariable Long parent_id,
                                             @PathVariable Long user_id){
        Comment res = commentService.createReplayOnComment(comment,parent_id,user_id);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
