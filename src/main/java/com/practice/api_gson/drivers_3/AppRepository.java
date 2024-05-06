package com.practice.api_gson.drivers_3;

import com.practice.api_gson.controllers_2.CommentDto;
import com.practice.api_gson.controllers_2.StoryItemDto;
import com.practice.api_gson.drivers_3.DBStoryItem;

import java.util.List;
import java.util.Optional;

public interface AppRepository {
    Iterable<DBStoryItem> saveAllStories(List<DBStoryItem> stories);

    DBStoryItem getStoryByTitle(String title);

    Iterable<DBStoryItem> getAllTopStories(int page, int size);

    Optional<DBStoryItem> getStoryById(int storyId);

    Iterable<DBStoryItem> saveAllStoryItems(List<StoryItemDto> allStoryItems);

    Iterable<DBCommentItem> saveAllComments(List<CommentDto> comments);
}
