package com.practice.api_gson.domain.services;

import com.google.gson.GsonBuilder;
import com.practice.api_gson.application.CommentDto;
import com.practice.api_gson.application.StoryItemDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.net.http.HttpResponse.BodyHandlers.ofString;

@Service
public class HackerNewsService {
    private final String baseurl = "https://hacker-news.firebaseio.com/v0/";
    private final int TOP_LIMIT = 500;
    private final HttpClient client = HttpClient.newHttpClient();

//    @Autowired private CommentsRepoImpl commentsRepo;

    public List<CommentDto> getCommentsForStory(int[] kids, int storyId) {

        HttpClient client = HttpClient.newHttpClient();

        var commentsHttp = Arrays.stream(kids)
                .mapToObj(commentId -> buildUri("item/" + commentId + ".json"))
                .map(HttpRequest::newBuilder)
                .map(HttpRequest.Builder::build)
                .toList();

        var comments = commentsHttp.parallelStream()
                .map(req -> makeRequest(req, client))
                .map(resp -> new GsonBuilder().create().fromJson(resp.body(), CommentDto.class))
                .toList();

        return comments;
    }

    public List<StoryItemDto> getTopStories() throws Exception {
        HttpClient client = HttpClient.newHttpClient();

        var idReq = HttpRequest.newBuilder()
                .uri(new URI(baseurl + "topstories.json"))
                .build();
        var idResp = client.send(idReq, ofString());
        var uris = Arrays.stream(new GsonBuilder().create().fromJson(idResp.body(), Integer[].class))
                .limit(TOP_LIMIT)
                .map(id -> buildUri("item/" + id + ".json"))
                .toList();

        List<HttpRequest> requests = uris.stream()
                .map(HttpRequest::newBuilder)
                .map(HttpRequest.Builder::build)
                .toList();

        List<StoryItemDto> storyNewsItems = requests.parallelStream()
                .map(req -> makeRequest(req, client))
                .filter(Objects::nonNull)
                .map(item -> new GsonBuilder().create().fromJson(item.body(), StoryItemDto.class))
                .toList();

        return storyNewsItems;
    }

    private URI buildUri(String path) {
        try {
            return new URI(baseurl + path);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private HttpResponse<String> makeRequest(HttpRequest request, HttpClient client) {
        try {
            return client.send(request, ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


