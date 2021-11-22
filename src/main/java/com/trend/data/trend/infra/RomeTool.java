package com.trend.data.trend.infra;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.trend.data.trend.domain.TrendModel;
import com.trend.data.trend.service.Rss;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.util.ArrayUtils;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class RomeTool implements Rss {

    @Override
    public List<TrendModel> reader(String url) {
        try {
            XmlReader reader = new XmlReader(new URL(url));
            SyndFeed feed = new SyndFeedInput().build(reader);
            return makeTrendModel(feed);
        }  catch (Exception e) {
            e.printStackTrace();
            //TODO log 처리
        }
        return Collections.emptyList();
    }

    private List<TrendModel> makeTrendModel(SyndFeed feed) {
        List<TrendModel> trendModels = new ArrayList<>();
        LocalDate now = LocalDate.now();

        for (int i = 0; i < feed.getEntries().size(); i++) {
            LocalDate feedDate = getDate(feed, i);
            if(!now.equals(feedDate))
                break;

            TrendModel trendModel = new TrendModel(
                    i+1,
                    feed.getEntries().get(i).getTitle(),
                    feed.getEntries().get(i).getDescription().getValue());
            trendModels.add(trendModel);
        }
        return trendModels;
    }

    private LocalDate getDate(SyndFeed feed, int i) {
        return feed.getEntries().get(i).getPublishedDate()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

}
