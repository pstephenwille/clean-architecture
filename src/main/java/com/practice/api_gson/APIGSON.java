package com.practice.api_gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.practice.api_gson.domain.StoryItemEntity;
import com.practice.api_gson.domain.repositories.StoryItemRepo;
import com.practice.api_gson.domain.services.HackerNewsService;
import com.practice.api_gson.infra.persistence.StoryRepo;
import com.practice.api_gson.presentation.HomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;

@SpringBootApplication
public class APIGSON {

    static HackerNewsService service = new HackerNewsService();
    static StoryRepo storyRepo = new StoryRepo();

    public static void main(String[] args) throws Exception {
        SpringApplication.run(APIGSON.class, args);

        var allStoryItems = service.getTopStoryItems();
        storyRepo.saveAllStoryItems(allStoryItems);
    }

}
