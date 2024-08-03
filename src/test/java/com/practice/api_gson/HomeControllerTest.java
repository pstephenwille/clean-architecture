package com.practice.api_gson;

import com.practice.api_gson.controllers_2.ApiGsonService;
import com.practice.api_gson.controllers_2.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
public class HomeControllerTest {

    @Mock
    private ApiGsonService apiGsonService;

    @InjectMocks
    private HomeController sut;

    @BeforeEach
    public void setup() {
    }


    @Test
    void testGetTopStories() throws Exception {
        when(apiGsonService.getTopStories()).thenReturn(null);

        var actual = sut.getTopStoryItems();

        assertThat(actual).isEqualTo(null);
    }

}
