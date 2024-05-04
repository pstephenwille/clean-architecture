package com.practice.api_gson.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue
    int id;
    String by;
    @Column(columnDefinition = "TEXT")
    String text;
    int[] kids;
    int parent;
}
