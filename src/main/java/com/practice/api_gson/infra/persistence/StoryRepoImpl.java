package com.practice.api_gson.infra.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.api_gson.application.StoryItemDto;
import com.practice.api_gson.domain.StoryItemEntity;
import com.practice.api_gson.domain.repositories.StoryItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class StoryRepoImpl {

    @Autowired()
    public StoryItemRepo storyItemRepo;

    public Optional<StoryItemEntity> getById(int storyId) {
        return storyItemRepo.findById(storyId);
    }

    public Iterable<StoryItemEntity> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StoryItemEntity> items = storyItemRepo.findAll(pageable);

        return items;
    }

    public void saveAllStoryItems(List<StoryItemDto> allStoryItems) {
        Gson gson = new Gson();
        var allStoryEntities = allStoryItems.stream()
                .map(gson::toJson)
                .map(item -> new GsonBuilder().create().fromJson(item, StoryItemEntity.class))
                .toList();

        storyItemRepo.saveAll(allStoryEntities);
    }
}
