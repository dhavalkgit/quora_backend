package com.example.quora.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(nullable = false, unique = true)
    private String topicName;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "topics")
    @JsonIgnore
    private List<Question>questions;
}
