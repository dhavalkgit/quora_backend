package com.example.quora.controller;

import com.example.quora.adapter.AnswerDtoToAnswerAdapter;
import com.example.quora.dtos.AnswerDto;
import com.example.quora.models.Answer;
import com.example.quora.services.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answers")
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerDtoToAnswerAdapter answerAdapter;

    public AnswerController(AnswerService answerService,  AnswerDtoToAnswerAdapter answerAdapter){
        this.answerService=answerService;
        this.answerAdapter=answerAdapter;
    }

    @PostMapping(value = "/{question_id}/questions")
    public ResponseEntity<?> writeAnswer(@RequestBody AnswerDto answerDto, @PathVariable Long question_id){
        Answer answer = answerAdapter.AnswerDtoToAnswer(answerDto,question_id);
        Answer res = answerService.createAnswer(answer);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{answer_id}")
    public ResponseEntity<?> updateAnswer(@RequestBody AnswerDto answerDto, @PathVariable Long answer_id){
        Answer res = answerService.updateAnswer(answerDto.getText(),answer_id);
        return ResponseEntity.ok(res);
    }
}
