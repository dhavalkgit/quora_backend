package com.example.quora.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Topics extends BaseModel{

    private String topicName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "question_topic",
    joinColumns = @JoinColumn(name = "topic_id"),
    inverseJoinColumns = @JoinColumn(name = "question_id"))
    private List<Question>questions;
}
