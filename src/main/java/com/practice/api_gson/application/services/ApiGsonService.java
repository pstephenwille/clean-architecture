package com.practice.api_gson.application.services;

import com.practice.api_gson.domain.CommentEntity;
import com.practice.api_gson.domain.HackerNewsProvider;
import com.practice.api_gson.domain.StoryItemEntity;
import com.practice.api_gson.domain.repositories.CommentsRepo;
import com.practice.api_gson.domain.repositories.MyCommentsRepo;
import com.practice.api_gson.domain.repositories.MyStoryItemRepo;
import com.practice.api_gson.domain.repositories.StoryItemRepo;
import com.practice.api_gson.infra.persistence.CommentsRepositoryImpl;
import com.practice.api_gson.infra.persistence.StoryItemRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiGsonService {

//    @Autowired
//    private StoryItemRepositoryImpl storyRepo;

//    @Autowired
//    private CommentsRepositoryImpl commentsRepo;

    private final MyStoryItemRepo storyItemRepo;
    private final MyCommentsRepo commentsRepo;

    private final HackerNewsProvider hackerNewsProvider;

    @Autowired
    public ApiGsonService(HackerNewsProvider hackerNews, MyStoryItemRepo storyItemRepo, MyCommentsRepo commentsRepo1) {
        this.hackerNewsProvider = hackerNews;
        this.storyItemRepo = storyItemRepo;
        this.commentsRepo = commentsRepo1;
    }


    public Iterable<CommentEntity> getCommentsForStory(int storyId) {
        var storyEntity = storyItemRepo.getStoryById(storyId).get();
        var kids = storyEntity.kids;
        var parentId = storyEntity.storyId;

        var commentsForStory = commentsRepo.getCommentsForStory(parentId);

        if (commentsForStory.iterator().hasNext()) {
            return commentsForStory;
        }

        var newComments = hackerNewsProvider.getCommentsForStory(kids);
        commentsRepo.saveAllComments(newComments);

        return this.getCommentsForStory(storyId);
    }


    public Iterable<StoryItemEntity> getTopStories() {
        return storyItemRepo.getAllTopStories(0, 10);
    }
}


