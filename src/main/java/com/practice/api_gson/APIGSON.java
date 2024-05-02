package com.practice.api_gson;

import com.practice.api_gson.domain.services.HackerNewsService;
import com.practice.api_gson.infra.persistence.StoryRepoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class APIGSON {
    static HackerNewsService service;
    public static StoryRepoImpl staticStoryRepo;

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(APIGSON.class, args);
        service = applicationContext.getBean(HackerNewsService.class);
        staticStoryRepo = applicationContext.getBean(StoryRepoImpl.class);

        var allStoryItems = service.getTopStories();

        staticStoryRepo.saveAllStoryItems(allStoryItems);
    }

}
