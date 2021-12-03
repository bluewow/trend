package com.trend.data.application.trend.service;

import com.trend.data.application.trend.domain.TrendModel;
import com.trend.data.application.trend.service.Rss;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@PropertySource("classpath:constant.properties")
@RequiredArgsConstructor
@Component
public class SchedulerService {

    private final Rss rss;

    @Value("${google.trend.url}")
    private String googleURL;

    private List<TrendModel> data = new ArrayList<>();

    /**
     * 매일 오후 5시 데이터를 수집한다
     */
    @Scheduled(cron = "0 0 17 ? * *")
    @Async
    public void getDataTask() {
        List<TrendModel> trendModels = rss.reader(googleURL);
        data = trendModels;
    }

    /**
     * 매일 오후 6시 수집한 데이터를 토대로 메시지를 전달한다
     */
    @Scheduled(cron = "0 0 18 ? * *")
    @Async
    public void messagePushTask() {
        System.out.println(data.toString());
    }

}
