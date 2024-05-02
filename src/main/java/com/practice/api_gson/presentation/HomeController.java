package com.practice.api_gson.presentation;

import com.google.gson.Gson;
import com.practice.api_gson.domain.services.HackerNewsService;
import com.practice.api_gson.infra.persistence.StoryRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {
    @Autowired
    HackerNewsService hackerNewsService;

    @Autowired
    private StoryRepoImpl storyRepo;

    @GetMapping("/top-stories")
    public ResponseEntity<String> getTopStoryItems() throws Exception {
        var items = storyRepo.findAll(0, 10);
        Gson gson = new Gson();
        String gsonJson = gson.toJson(items);

        return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON).body(gsonJson);
    }

    @GetMapping("/comments/{parentId}")
    public ResponseEntity<String> getCommentsForParentItem(@PathVariable Integer parentId) throws Exception {
        var story = Optional.of(storyRepo.getById(parentId)).get();

        if (story.isEmpty()) {
            return ResponseEntity.status(404).body("storyID not found");
        }

        var kids = story.get().kids;
//        var comments = hackerNewsService.getCommentsForStory(kids, story.get().story_id);

        return ResponseEntity.status(200).body(parentId.toString());
    }
}

