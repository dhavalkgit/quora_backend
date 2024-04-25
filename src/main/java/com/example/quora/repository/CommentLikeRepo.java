package com.example.quora.repository;

import com.example.quora.models.CommentLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentLikeRepo extends JpaRepository<CommentLike,Long> {
}
