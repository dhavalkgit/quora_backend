package com.example.quora.controller;

import com.example.quora.dtos.TopicResponseDto;
import com.example.quora.helper.TopicHelper;
import com.example.quora.models.Topics;
import com.example.quora.services.TopicsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/tags")
public class TopicController {
    private final TopicsService topicsService;
    private final TopicHelper topicHelper;

    public TopicController(TopicsService topicsService, TopicHelper topicHelper){
        this.topicsService = topicsService;
        this.topicHelper = topicHelper;
    }

    @PostMapping("/")
    public ResponseEntity<?> addTopic(@RequestBody Topics topics){
        Topics res = topicsService.createTopic(topics);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllTopics(){
        List<Topics> res = topicsService.getTopics();
        List<TopicResponseDto> topicResponseDtos = new ArrayList<>();
        for(Topics topics : res){
            topicResponseDtos.add(topicHelper.sendTopicResponse(topics));
        }
        return ResponseEntity.ok(topicResponseDtos);
    }

    @GetMapping("/{tag}")
    public ResponseEntity<?> getTopic(@PathVariable String tag){
        Topics res = topicsService.getSingleTopic(tag);
        return ResponseEntity.ok(res);
    }
}
