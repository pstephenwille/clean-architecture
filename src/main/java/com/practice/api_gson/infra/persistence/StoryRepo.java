package com.practice.api_gson.infra.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.api_gson.application.StoryItemDto;
import com.practice.api_gson.domain.StoryItemEntity;
import com.practice.api_gson.domain.repositories.StoryItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class StoryRepo {

    @Autowired
    private StoryItemRepo storyItemRepo;

    public void saveAllStoryItems(List<StoryItemDto> allStoryItems) {
        Gson gson = new Gson();
        var allStoryEntities = allStoryItems.stream()
                .map(gson::toJson)
                .map(item -> new GsonBuilder().create().fromJson(item, StoryItemEntity.class))
                .toList();

        storyItemRepo.saveAll(allStoryEntities);
    }
}
