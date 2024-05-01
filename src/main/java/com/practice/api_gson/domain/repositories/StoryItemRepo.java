package com.practice.api_gson.domain.repositories;

import com.practice.api_gson.domain.StoryItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryItemRepo extends CrudRepository<StoryItemEntity, Integer> {}
