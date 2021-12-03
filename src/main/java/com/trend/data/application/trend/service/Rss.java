package com.trend.data.application.trend.service;

import com.trend.data.application.trend.domain.TrendModel;

import java.util.List;

public interface Rss {
    List<TrendModel> reader(String url);
}
