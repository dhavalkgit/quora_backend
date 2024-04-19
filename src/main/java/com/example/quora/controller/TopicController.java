package com.example.quora.controller;

import com.example.quora.models.Topics;
import com.example.quora.services.TopicsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
public class TopicController {
    private final TopicsService topicsService;

    public TopicController(TopicsService topicsService){
        System.out.println("*******");
        this.topicsService = topicsService;
    }

    @PostMapping("/")
    public ResponseEntity<?> addTopic(@RequestBody Topics topics){
        System.out.println("///////////////////////");
        Topics res = topicsService.createTopic(topics);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTopics(){
        System.out.println("*******");
        List<Topics> res = topicsService.getTopics();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/{tag}")
    public ResponseEntity<?> getTopic(@PathVariable String tag){
        System.out.println("*******");
        Topics res = topicsService.getSingleTopic(tag);
        return ResponseEntity.ok(res);
    }
}
