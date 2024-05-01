package com.practice.api_gson.application;

import lombok.Data;

@Data
public class CommentDto {
    int id;
    String by;
    String text;
    int[] kids;
    String parent;
}
