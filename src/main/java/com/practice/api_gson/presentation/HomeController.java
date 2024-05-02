package com.practice.api_gson.presentation;

import com.google.gson.Gson;
import com.practice.api_gson.domain.StoryItemEntity;
import com.practice.api_gson.domain.services.HackerNewsService;
import com.practice.api_gson.infra.persistence.StoryRepo;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {
    @Autowired
    HackerNewsService hackerNewsService;

    @Autowired
    private StoryRepo storyRepo;

    @GetMapping("/top-stories")
    public ResponseEntity<String> getTopStoryItems() throws Exception {
        var items = storyRepo.findAll();
        Gson gson = new Gson();
        String gsonJson = gson.toJson(items);

        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(gsonJson);
    }

    @GetMapping("/comments/{parentId}")
    public ResponseEntity<String> getCommentsForParentItem(@PathVariable Integer parentId) throws Exception {
        return ResponseEntity.status(200).body(parentId.toString());
    }
}

