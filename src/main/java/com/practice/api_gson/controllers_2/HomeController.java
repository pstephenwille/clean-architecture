package com.practice.api_gson.controllers_2;

import com.practice.api_gson.drivers_3.DBCommentItem;
import com.practice.api_gson.drivers_3.DBStoryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
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
    public Iterable<DBStoryItem> getTestItems() throws Exception {
        return apiGsonService.getTopStories();
    }

    @GetMapping("/test")
    public @ResponseBody Iterable<DBStoryItem> getTopStoryItems() throws Exception {
        var items = apiGsonService.getTopStories();
        return items;
    }

    @GetMapping("/comments/{parentId}")
    public Iterable<DBCommentItem> getCommentsForParentItem(@PathVariable Integer parentId) throws Exception {
        return apiGsonService.getCommentsForStory(parentId);
    }
}

