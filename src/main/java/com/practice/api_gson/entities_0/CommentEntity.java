package com.practice.api_gson.entities_0;

public record CommentEntity(
        int id,
        String by,
        String text,
        int[] kids,
        int parent
) {
}
