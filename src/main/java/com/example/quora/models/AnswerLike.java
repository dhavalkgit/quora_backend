package com.example.quora.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnswerLike extends Like{
    @ManyToOne
    @JoinColumn(name = "answer_id")
    @JsonIgnore
    private Answer answer;
}
