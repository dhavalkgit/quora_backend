package com.example.quora.services;

import com.example.quora.models.Topics;

import java.util.List;

public interface TopicsService {
    public Topics createTopic(Topics topic);
    public List<Topics> getTopics();
    public Topics getSingleTopic(String tag);
}
