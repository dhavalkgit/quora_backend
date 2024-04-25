package com.example.quora.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentLike extends Like{

    @ManyToOne
    @JoinColumn(name = "comment_id")
    @JsonIgnore
    private Comment comment;
}
