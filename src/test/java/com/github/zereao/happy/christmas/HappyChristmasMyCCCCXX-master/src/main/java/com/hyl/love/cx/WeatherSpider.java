package com.hyl.love.cx;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherSpider {
    public static List<String> weatherSpider() throws IOException {
        List<String> weatherInfoList = new ArrayList<>();
        String URL = "http://www.weather.com.cn/weather/101121001.shtml";
        Document doc = Jsoup.connect(URL).get();
        Elements content = doc.getElementsByClass("con today clearfix");
        Iterator var4 = content.iterator();
        while (var4.hasNext()) {
            Element element = (Element) var4.next();
            Document conDoc = Jsoup.parse(element.toString());
            Elements cityElement = conDoc.getElementsByClass("crumbs fl");
            Elements everydayInfoElem = content.select("li[class^=sky skyid lv]");
            String cityName = cityElement.text();
            weatherInfoList.add(cityName);
            Iterator var10 = everydayInfoElem.iterator();
            while (var10.hasNext()) {
                Element everyInfo = (Element) var10.next();
                weatherInfoList.add(everyInfo.text());
            }
        }
        return weatherInfoList;
    }
}
