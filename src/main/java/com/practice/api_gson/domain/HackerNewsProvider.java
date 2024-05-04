package com.practice.api_gson.domain;

import com.practice.api_gson.application.CommentDto;
import com.practice.api_gson.application.StoryItemDto;

import java.util.List;

public interface HackerNewsProvider {
    int TOP_LIMIT = 500;
    String baseurl = "https://hacker-news.firebaseio.com/v0/";

    List<StoryItemDto> getTopStories() throws Exception;

    List<CommentDto> getCommentsForStory(int[] kids);
}
