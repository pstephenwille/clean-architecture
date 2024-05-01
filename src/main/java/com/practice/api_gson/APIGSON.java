package com.practice.api_gson;

import com.practice.api_gson.domain.services.HackerNewsService;
import com.practice.api_gson.infra.persistence.StoryRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class APIGSON {
    static HackerNewsService service;
    public static StoryRepo staticStoryRepo;

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(APIGSON.class, args);
        service = applicationContext.getBean(HackerNewsService.class);
        staticStoryRepo = applicationContext.getBean(StoryRepo.class);

        var allStoryItems = service.getTopStoryItems();

        staticStoryRepo.saveAllStoryItems(allStoryItems);
    }

}
