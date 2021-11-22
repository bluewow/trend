package com.trend.data.trend.service;

import com.trend.data.trend.domain.TrendModel;

import java.util.List;

public interface Rss {
    List<TrendModel> reader(String url);
}
