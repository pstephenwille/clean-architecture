package com.practice.ts.PracticeTwo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "stories")
public class StoryItemDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    int _id;
    @Column(name = "story_id")
    int id;
    String by;
    int[] kids;
    String title;
    String type;
}
