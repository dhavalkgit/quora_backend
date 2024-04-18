package com.example.quora.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @UpdateTimestamp(source = SourceType.VM)
    @Column(nullable = false)
    protected Date createdAt;

    @UpdateTimestamp(source = SourceType.VM)
    @Column(nullable = false)
    protected Date updatedAt;
}
