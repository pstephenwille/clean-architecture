package com.practice.api_gson;

import com.practice.api_gson.controllers_2.MyController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = MyController.class)
public class MYControllerTest {

    @Mock
    private HttpClient httpClient;

    @InjectMocks
    private MyController sut;

    @BeforeEach
    public void setUp() {
//        sut = new MyController();
    }

    @Test
    public void testTallyDistinctWords() {
        String[] allWords = {"a", "b", "c", "d", "e", "f", "d", "e", "f", "e", "f", "e", "f"};

        var tally = sut.tallyDistinctWords(allWords);

        assertThat(tally.get("f")).isEqualTo(4);
    }

    @Test
    public void testGetData() throws Exception {
        String mockedResponse = "111";
        var mockResponse = mock(HttpResponse.class);
        when(mockResponse.body()).thenReturn("[111,222]");
        when(httpClient.send(any(), any())).thenReturn(mockResponse);

        var actual = sut.getData("111");

        assertThat(actual.get(0)).isEqualTo(111);
    }

}
