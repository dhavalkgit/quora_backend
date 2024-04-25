package com.example.quora.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;

import java.util.Date;


@Getter
@Setter
@MappedSuperclass
public abstract class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    protected User user;

    @CreationTimestamp(source = SourceType.VM)
    protected Date createdAt;
}
