package com.hyl.love.cx;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import static com.hyl.love.cx.MailSender.sendMail;
import static com.hyl.love.cx.WeatherSpider.weatherSpider;

public class Gift {

    public static void main(String[] args) throws MessagingException, ParseException, IOException, InterruptedException {
        Thread.sleep(new DateOperator().getSleepTime());
        List<String> weatherInfoList = null;
        String subject = "";
        StringBuilder content = null;
        int i = 2;
        while (true) {
            weatherInfoList = weatherSpider();
            content = new StringBuilder();
            subject = "何宝大人爱小胖宝的第 " + (new DateOperator()).calculateDate() + " 个天晴~~么么哒~~~";
            content.append("&nbsp;&nbsp;&nbsp;&nbsp;").append(new LuvLetter().getLuvLetter(i)).append("<br>");
            content.append("&nbsp;&nbsp;&nbsp;&nbsp;以下是接下来一周的天气预报，爱你，我的胖~~~~").append("<br><br>");
            for (int j = 0; j < weatherInfoList.size(); ++j) {
                content.append("&nbsp;&nbsp;&nbsp;&nbsp;").append((String) weatherInfoList.get(j)).append("<br>");
            }
            sendMail(subject, content.toString());
            ++i;
            if (i == 7) {
                i = 0;
            }
            Thread.sleep(24 * 60 * 60 * 1000);
        }
    }
}










