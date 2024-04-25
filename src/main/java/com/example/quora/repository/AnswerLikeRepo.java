package com.example.quora.repository;

import com.example.quora.models.AnswerLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerLikeRepo extends JpaRepository<AnswerLike, Long> {
}
