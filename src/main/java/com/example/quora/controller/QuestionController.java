package com.example.quora.controller;

import com.example.quora.adapter.DtoQuestionToQuestionAdapter;
import com.example.quora.dtos.DtoQuestion;
import com.example.quora.models.Question;
import com.example.quora.services.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {

    private final QuestionService q_service;
    private final DtoQuestionToQuestionAdapter questionAdapter;

    public QuestionController(QuestionService q_service, DtoQuestionToQuestionAdapter questionAdapter){
        this.questionAdapter = questionAdapter;
        this.q_service = q_service;
    }

    @PostMapping("/")
    public ResponseEntity<?> postQuestion(@RequestBody DtoQuestion dtoQuestion){
        Question question = questionAdapter.dtoQuestionToQuestion(dtoQuestion);
        Question res = q_service.createQuestion(question);
        return new ResponseEntity<> (res, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "keyword") String keyword){
        List<Question> res = q_service.searchQuestion(keyword);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{question_id}")
    public ResponseEntity<?> updateQuestion(@PathVariable Long question_id){
        return null;
    }
}
