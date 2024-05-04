package com.practice.api_gson.domain.repositories;

import com.practice.api_gson.domain.StoryItemEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

public interface StoryItemRepo extends CrudRepository<StoryItemEntity, Integer> {
    Page<StoryItemEntity> findAll(Pageable pageable);

    StoryItemEntity findByTitle(String story_id);

    StoryItemEntity findByStoryId(int story_id);

}
