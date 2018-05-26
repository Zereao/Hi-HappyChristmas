package com.github.zereao.happy.christmas.service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Zereao
 * @version 2018/05/24/16:16
 */
@Service
public class SpiderService {
    /**
     * @param cityCode 城市代码
     * @return 包含天气信息的JsonArray
     * @throws IOException 访问链接失败
     */
    public JSONObject weatherSpider(String cityCode) throws IOException, ParseException {
        JSONObject resultJson = new JSONObject();
        String URL = "http://www.weather.com.cn/weathern/" + cityCode + ".shtml";
        Document doc = Jsoup.connect(URL).get();
        // 组装地区信息
        Element wheatherLocation = doc.getElementsByClass("weather_location").get(0);
        StringBuilder loc = new StringBuilder();
        String citySelect = wheatherLocation.getElementsByClass("citySelect webox").get(0).select("a").get(0).text();
        loc.append(citySelect).append(" > ");
        Elements areaSelect = wheatherLocation.getElementsByClass("areaSelect webox");
        for (Element element : areaSelect) {
            loc.append(element.select("a").get(0).text()).append(" > ");
        }
        String selectAre = wheatherLocation.getElementsByClass("webox areaSelect").get(0).select("a").get(0).text();
        loc.append(selectAre);
        resultJson.put("area", loc.toString());
        // 组装天气信息JsonArray
        JSONArray resultJsonArray = new JSONArray();
        Elements elements = doc.getElementsByTag("script");
        for (Element element : elements) {
            String elemStr = element.toString();
            if (elemStr.contains("hour3data")) {
                JSONArray jsonArray = JSONArray.fromObject(elemStr.substring(elemStr.indexOf("["), elemStr.lastIndexOf("]") + 1));
                for (Object jsonArrayObj : jsonArray) {
                    JSONArray eachDayJsonArray = (JSONArray) jsonArrayObj;
                    for (Object eachDayJsonObj : eachDayJsonArray) {
                        String[] windType_jd = new String[]{"无持续风向", "东北风", "东风", "东南风", "南风", "西南风", "西风", "西北风", "北风", "旋转风"};
                        String[] windStrength_jc = new String[]{"<3级", "3-4级", "4-5级", "5-6级", "6-7级", "7-8级", "8-9级", "9-10级", "10-11级", "11-12级"};
                        JSONObject json = (JSONObject) eachDayJsonObj;
                        JSONObject tempJson = new JSONObject();
                        tempJson.put("windDirection", windType_jd[Integer.parseInt(json.getString("jd"))]);
                        tempJson.put("windStrength", windStrength_jc[Integer.parseInt(json.getString("jc"))]);
                        tempJson.put("temperature", json.getString("jb") + "℃");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH点");
                        String time = sdf.format(new SimpleDateFormat("yyyyMMddHH").parse(json.getString("jf")));
                        tempJson.put("time", time);
                        resultJsonArray.add(tempJson);
                    }
                }
            }
        }
        resultJson.put("weatherArray", resultJsonArray);
        return resultJson;
    }
}
