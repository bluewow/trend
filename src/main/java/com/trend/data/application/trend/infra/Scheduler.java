package com.trend.data.application.trend.infra;

import com.trend.data.application.trend.domain.TrendModel;
import com.trend.data.application.trend.service.Rss;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@PropertySource("classpath:constant.properties")
@RequiredArgsConstructor
@Component
public class Scheduler {

    private final Rss rss;

    @Value("${google.trend.url}")
    private String googleURL;

    @Scheduled(fixedDelay = 1000)
    @Async
    public void getDataTask() {
        List<TrendModel> trendModels = rss.reader(googleURL);
        for (TrendModel trendModel : trendModels) {
            System.out.println(trendModel.toString());
        }
    }
}
