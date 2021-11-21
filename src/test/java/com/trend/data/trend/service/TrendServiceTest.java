package com.trend.data.trend.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrendServiceTest {

    @Autowired
    TrendService trendService;

    @Test
    void test() {
        trendService.test();
    }
}