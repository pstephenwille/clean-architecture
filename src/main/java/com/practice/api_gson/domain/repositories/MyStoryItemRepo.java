package com.practice.api_gson.domain.repositories;

import com.practice.api_gson.application.StoryItemDto;
import com.practice.api_gson.domain.StoryItemEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MyStoryItemRepo extends StoryItemRepo {
    StoryItemEntity getByTitle(String title);

    Iterable<StoryItemEntity> getAllTopStories(int page, int size);

    Optional<StoryItemEntity> getStoryById(int storyId);

    Iterable<StoryItemEntity> saveAllItems(List<StoryItemDto> allStoryItems);
}
