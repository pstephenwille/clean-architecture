package com.practice.api_gson.application;

//@Data
public record CommentDto(int id,
                         String by,
                         String text,
                         int[] kids,
                         String parent,
                         String type) {
};
