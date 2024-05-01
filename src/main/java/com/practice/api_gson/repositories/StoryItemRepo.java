package com.practice.api_gson.repositories;

import com.practice.api_gson.models.StoryItemDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoryItemRepo extends CrudRepository<StoryItemDto, Integer> {}
