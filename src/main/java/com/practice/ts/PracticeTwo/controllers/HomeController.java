package com.practice.ts.PracticeTwo.controllers;

import com.practice.ts.PracticeTwo.models.StoryItemDto;
import com.practice.ts.PracticeTwo.repositories.StoryItemRepo;
import com.practice.ts.PracticeTwo.services.HackerNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    HackerNewsService hackerNewsService;

    @Autowired
    private StoryItemRepo storyItemRepo;

    public List<StoryItemDto> getTopStoryItems() throws Exception {
        var result = new HackerNewsService().getWithGson();
        storyItemRepo.saveAll(result);

        return result;
    }

}
