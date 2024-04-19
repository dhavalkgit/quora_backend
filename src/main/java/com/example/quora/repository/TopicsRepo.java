package com.example.quora.repository;

import com.example.quora.models.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsRepo extends JpaRepository<Topics,Long> {
    public Topics findByTopicName(String name);
}
