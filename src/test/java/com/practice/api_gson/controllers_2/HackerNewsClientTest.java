package com.practice.api_gson.controllers_2;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = HackerNewsClient.class)
class HackerNewsClientTest {

    @Mock
    private HttpResponse mockResponse;
    @Mock
    private HttpClient mockClient;

    @InjectMocks
    private HackerNewsClient sut;

    @Test
    public void testGetStopStories() throws Exception {
        when(mockResponse.body())
                .thenReturn("[111,222]")
                .thenReturn("{}");
        when(mockClient.send(any(), any())).thenReturn(mockResponse);
        var actual = sut.getTopStories();

        assertThat(actual.get(0)).isOfAnyClassIn(StoryItemDto.class);
    }
}
