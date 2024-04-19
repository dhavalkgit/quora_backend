package com.example.quora.services.Impl;

import com.example.quora.models.Topics;
import com.example.quora.repository.TopicsRepo;
import com.example.quora.services.TopicsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicsServiceImpl implements TopicsService {

    private final TopicsRepo topicsRepo;

    public TopicsServiceImpl(TopicsRepo topicsRepo){
        this.topicsRepo = topicsRepo;
    }

    @Override
    public Topics createTopic(Topics topic) {
        return topicsRepo.save(topic);
    }

    @Override
    public List<Topics> getTopics() {
        return topicsRepo.findAll();
    }

    @Override
    public Topics getSingleTopic(String tag) {
        return topicsRepo.findByTopicName(tag);
    }
}
