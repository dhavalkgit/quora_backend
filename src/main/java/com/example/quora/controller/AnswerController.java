package com.example.quora.controller;

import com.example.quora.models.Answer;
import com.example.quora.services.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answer")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService){
        this.answerService=answerService;
    }

    @PostMapping(value = "/questions/{q_id}/users/{u_id}")
    public ResponseEntity<?> postAnswer(@RequestBody Answer answer, @PathVariable Long q_id,
                                        @PathVariable Long u_id){
        System.out.println("coming!");
        Answer res = answerService.createAnswer(answer, q_id, u_id);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAnswer(@RequestBody Answer answer, @PathVariable Long id){
        Answer res = answerService.updateAnswer(answer,id);
        return ResponseEntity.ok(res);
    }
}
