package com.example.quora.repository;

import com.example.quora.models.QuestionLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionLikeRepo extends JpaRepository<QuestionLike,Long> {
}
