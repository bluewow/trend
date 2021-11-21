package com.trend.data.trend.service;

import com.trend.data.trend.infra.RomeTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TrendService {
    private final FeedRss feedRss;

    void test() {
        feedRss.googleTrendParser();
    }
}
