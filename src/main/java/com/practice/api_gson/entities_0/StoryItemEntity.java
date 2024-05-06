package com.practice.api_gson.entities_0;

public record StoryItemEntity(
        int id,
        int storyId,
        String by,
        int[] kids,
        String title,
        String type
) {
}
