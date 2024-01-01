package com.practice.ts.PracticeTwo;

import com.practice.ts.PracticeTwo.controllers.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class HomeControllerTest {

    /*sut system under test */
    @Autowired
    private HomeController sut;

    int itemCount = 10;

    @BeforeEach
    public void setup() {
    }


    @Test
    void testGetTopNewsHttpStream() throws Exception {
//        2.1, 1, 0.9
        var actual = sut.getTopStoryItems();
        assertThat(actual.size()).isEqualTo(itemCount);
    }

}
