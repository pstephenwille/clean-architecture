package com.practice.api_gson.drivers_3;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface StoryItemRepo extends CrudRepository<DBStoryItem, Integer> {
    Page<DBStoryItem> findAll(Pageable pageable);

    DBStoryItem findByTitle(String story_id);

    DBStoryItem findByStoryId(int story_id);

}
