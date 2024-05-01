package com.practice.api_gson.presentation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.api_gson.domain.StoryItemEntity;
import com.practice.api_gson.domain.repositories.StoryItemRepo;
import com.practice.api_gson.domain.services.HackerNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    HackerNewsService hackerNewsService;

    @Autowired
    private StoryItemRepo storyItemRepo;

    @GetMapping("/top-stories")
    public String getTopStoryItems() throws Exception {
        var storyItems = new HackerNewsService().getTopStoryItems();
        Gson gson = new Gson();

        var foo = storyItems.stream()
                .map(gson::toJson)
                .map(item -> {
                    var ugh = new GsonBuilder().create().fromJson(item, StoryItemEntity.class);
                    return ugh;
                })
                .collect(Collectors.toList());


        String gsonJson = gson.toJson(foo);
        storyItemRepo.saveAll(foo);

        return gsonJson;
    }

}
//
