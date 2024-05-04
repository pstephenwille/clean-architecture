package com.practice.api_gson;

import com.practice.api_gson.domain.HackerNewsProvider;
import com.practice.api_gson.infra.persistence.StoryItemRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApiGson {
    public static StoryItemRepositoryImpl staticStoryRepo;
    public static HackerNewsProvider hackerNewsProvider;

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(ApiGson.class, args);
        hackerNewsProvider = applicationContext.getBean(HackerNewsProvider.class);

        staticStoryRepo = applicationContext.getBean(StoryItemRepositoryImpl.class);

        var allStoryItems = hackerNewsProvider.getTopStories();

        staticStoryRepo.saveAllStoryItems(allStoryItems);
    }

}
