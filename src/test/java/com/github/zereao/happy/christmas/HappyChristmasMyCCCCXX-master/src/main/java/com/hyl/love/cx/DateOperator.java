package com.hyl.love.cx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class DateOperator {
    public long calculateDate() {
        Properties prop = CommonUtil.loadProperties();
        String loveDate = prop.getProperty("lover.theDate");
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date love = null;
        try {
            love = sdf.parse(loveDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (now.getTime() - love.getTime()) / 86400000L;
    }

    public long getSleepTime() {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        Calendar nextDay = Calendar.getInstance();
        nextDay.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE) + 1, 7, 0, 0);
        return (nextDay.getTimeInMillis() - now.getTimeInMillis());
    }
}
