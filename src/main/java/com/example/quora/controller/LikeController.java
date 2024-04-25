package com.example.quora.controller;

import com.example.quora.dtos.LikeDto;
import com.example.quora.dtos.LikeResponseDto;
import com.example.quora.services.LikeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/likes")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @PostMapping("/")
    public ResponseEntity<LikeResponseDto> createLike(@RequestBody LikeDto likeDto, @RequestParam String type,
                                                      @RequestParam Long typeId){
        boolean b = likeService.addLike(type, typeId, likeDto.getUserId());
        if(b){
            LikeResponseDto response = LikeResponseDto.builder()
                    .message("Like added successfully")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        else{
            LikeResponseDto response = LikeResponseDto.builder()
                    .message("Like not added successfully")
                    .build();
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
