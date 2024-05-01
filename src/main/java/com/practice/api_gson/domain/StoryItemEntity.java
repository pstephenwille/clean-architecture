package com.practice.api_gson.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stories")
public class StoryItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int story_id;
    String by;
    @ElementCollection
    List<Integer> kids;
    String title;
    String type;

    @PrePersist
    private void setStory_id() {
        this.story_id = this.id;
    }
}