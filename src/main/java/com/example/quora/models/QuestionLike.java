package com.example.quora.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
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
public class QuestionLike extends Like{

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;
}
