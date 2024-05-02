package com.practice.api_gson.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    int id;
    String by;
    String text;
    @ElementCollection
    List<Integer> kids;
    int parent;
}
