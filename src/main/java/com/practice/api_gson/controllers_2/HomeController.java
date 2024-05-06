package com.practice.api_gson.controllers_2;

import com.practice.api_gson.drivers_3.DBCommentItem;
import com.practice.api_gson.drivers_3.DBStoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class HomeController {

    ApiGsonService apiGsonService;

    @Autowired
    public HomeController(ApiGsonService apiGsonService) {
        this.apiGsonService = apiGsonService;
    }

    @GetMapping("/top-stories")
    public Iterable<DBStoryItem> getTopStoryItems() throws Exception {
        return apiGsonService.getTopStories();
    }


    @GetMapping("/comments/{parentId}")
    public Iterable<DBCommentItem> getCommentsForParentItem(@PathVariable Integer parentId) throws Exception {
        return apiGsonService.getCommentsForStory(parentId);
    }
}

