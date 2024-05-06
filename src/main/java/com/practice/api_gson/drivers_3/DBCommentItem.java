package com.practice.api_gson.drivers_3;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class DBCommentItem {
    @Id
    @GeneratedValue
    public int id;
    public String by;
    @Column(columnDefinition = "TEXT")
    public String text;
    public int[] kids;
    public int parent;
}
