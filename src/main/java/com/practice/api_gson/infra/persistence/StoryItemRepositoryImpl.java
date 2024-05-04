package com.practice.api_gson.infra.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.api_gson.application.StoryItemDto;
import com.practice.api_gson.domain.StoryItemEntity;
import com.practice.api_gson.domain.repositories.MyStoryItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.error.MarkedYAMLException;

import java.util.List;
import java.util.Optional;

@Repository
public class StoryItemRepositoryImpl implements MyStoryItemRepo {

//    private final MyStoryItemRepo storyItemRepo;

//    @Autowired
//    public StoryItemRepositoryImpl(MyStoryItemRepo storyItemRepo) {
//        this.storyItemRepo = storyItemRepo;
//    }

    @Override
    public StoryItemEntity getByTitle(String title) {
        return null;
    }

    public Iterable<StoryItemEntity> getAllTopStories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<StoryItemEntity> items = storyItemRepo.findAll(pageable);

        return items;
    }

    public Optional<StoryItemEntity> getStoryById(int storyId) {
        return storyItemRepo.findById(storyId);
    }

    @Override
    public Iterable<StoryItemEntity> saveAllItems(List<StoryItemDto> allStoryItems) {
        Gson gson = new Gson();
        var allStoryEntities = allStoryItems.stream()
                .map(gson::toJson)
                .map(item -> new GsonBuilder().create().fromJson(item, StoryItemEntity.class))
                .toList();

        return storyItemRepo.saveAllItems(allStoryEntities);
    }
}
