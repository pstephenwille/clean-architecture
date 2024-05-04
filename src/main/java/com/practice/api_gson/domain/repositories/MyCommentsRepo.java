package com.practice.api_gson.domain.repositories;

import com.practice.api_gson.application.CommentDto;
import com.practice.api_gson.domain.CommentEntity;

import java.util.List;

public interface MyCommentsRepo extends CommentsRepo {
    void saveAllComments(List<CommentDto> commentDtos);

    Iterable<CommentEntity> getCommentsForStory(int parentId);
}
