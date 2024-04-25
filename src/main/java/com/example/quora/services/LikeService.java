package com.example.quora.services;

public interface LikeService {
    public boolean addLike(String type, Long typeId, Long userId);
}
