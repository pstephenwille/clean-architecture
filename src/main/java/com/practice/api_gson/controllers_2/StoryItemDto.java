package com.practice.api_gson.controllers_2;

public record StoryItemDto(
        int id,
        String by,
        int[] kids,
        String title,
        String type
) {
}
