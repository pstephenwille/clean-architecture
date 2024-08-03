package com.practice.api_gson.controllers_2;

import com.google.gson.GsonBuilder;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

@RestController
public class MyController {

    private  HttpClient client = HttpClient.newHttpClient();

    public HashMap<String, Integer> tallyDistinctWords(String[] allWords) {
        var uniques = new HashMap<String, Integer>();
        Arrays.stream(allWords).forEach((word) -> {
            uniques.put(word, uniques.getOrDefault(word, 0) + 1);
        });

        return uniques;
    }

    @GetMapping(path = "/my-test/{id}")
    public List<Integer> getData(@PathVariable String id)throws URISyntaxException, IOException, InterruptedException {
        var request = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
                .build();
        var topStoryIDs = client.send(request, ofString());
        var data = Arrays.stream(new GsonBuilder().create().fromJson(topStoryIDs.body(),
                                                                                  Integer[].class)).toList();

        return data;
    }
}
