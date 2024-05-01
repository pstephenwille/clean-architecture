package com.practice.api_gson.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.api_gson.models.StoryItemDto;
import com.practice.api_gson.repositories.StoryItemRepo;
import com.practice.api_gson.services.HackerNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    HackerNewsService hackerNewsService;

    @Autowired
    private StoryItemRepo storyItemRepo;

    @GetMapping("/top-stories")
    public  List<StoryItemDto> getTopStoryItems() throws Exception {
        var result = new HackerNewsService().getWithGson();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        storyItemRepo.saveAll(result);

        return result;
    }

}
