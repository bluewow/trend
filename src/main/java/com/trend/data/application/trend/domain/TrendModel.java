package com.trend.data.application.trend.domain;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TrendModel {
    private Integer rank;
    private String title;
    private String description;

    public TrendModel(int rank, String title, String description) {
        this.rank = rank;
        this.title = title;
        this.description = description;
    }
}
