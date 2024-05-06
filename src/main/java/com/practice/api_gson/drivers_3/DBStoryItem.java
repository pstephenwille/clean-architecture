package com.practice.api_gson.drivers_3;

import jakarta.persistence.*;

@Entity
@Table(name = "stories")
public class DBStoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column(name = "story_id")
    public int storyId;
    public String by;
    public int[] kids;
    public String title;
    public String type;

    @PrePersist
    private void setStoryId() {
        this.storyId = this.id;
    }
}
