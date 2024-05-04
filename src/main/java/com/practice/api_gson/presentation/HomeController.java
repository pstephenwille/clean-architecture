package com.practice.api_gson.presentation;

import com.google.gson.Gson;
import com.practice.api_gson.application.services.ApiGsonService;
import com.practice.api_gson.domain.HackerNewsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

    HackerNewsProvider hackerNewsProvider;
    ApiGsonService apiGsonService;

    @Autowired
    public HomeController(HackerNewsProvider hackerNewsProvider, ApiGsonService apiGsonService) {
        this.hackerNewsProvider = hackerNewsProvider;
        this.apiGsonService = apiGsonService;
    }

    @GetMapping("/top-stories")
    public ResponseEntity<String> getTopStoryItems() throws Exception {
        var items = apiGsonService.getTopStories();
        Gson gson = new Gson();
        String gsonJson = gson.toJson(items);

        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(gsonJson);
    }

    @GetMapping("/comments/{parentId}")
    public ResponseEntity<String> getCommentsForParentItem(@PathVariable Integer parentId) throws Exception {
        var comments = apiGsonService.getCommentsForStory(parentId);
        Gson gson = new Gson();
        String gsonJson = gson.toJson(comments);

        return ResponseEntity.status(200).body(gsonJson);
    }
}

