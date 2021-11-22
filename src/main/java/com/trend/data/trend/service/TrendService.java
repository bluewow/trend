package com.trend.data.trend.service;

import com.trend.data.trend.domain.TrendModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TrendService {
    private final Rss rss;

    List<TrendModel> googleTrendRanking() {
        return rss.reader("https://trends.google.co.kr/trends/trendingsearches/daily/rss?geo=KR");
    }
}
