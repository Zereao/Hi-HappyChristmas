package com.hyl.love.cx;

public class LuvLetter {
    private static final String MONDAY = "亲爱的胖胖宝~今天周一呢。新的一周，要更加努力哦！<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我闭着眼睛的时候看不见我自己，但我却能看到你，你说，神奇不神奇？";
    private static final String TUESDAY = "亲爱的小胖妞~今天周二哟。继续努力吧，我陪着你呢！<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;你是我的特效药。";
    private static final String WEDNESDAY = "亲爱的宝贝蛋~今天周三啦。ennnnnn，有一种强烈的感觉，到了周末，就能见到你。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;晚安，晚安。好梦，好梦。调好闹钟，你也是哦。明天要早早的起床呀！倒是你别睡过头啦！好啦好啦，别闹，睡了，乖。你也该休息啦。亲爱的，宝贝儿，我喜欢你。";
    private static final String THURSDAY = "亲爱的小心肝~今天周四咯。昨天的情话，看懂没有呢？<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我喜欢你，在所有时候，也喜欢有些人，在他们偶尔像你的时候。";
    private static final String FRIDAY = "亲爱的胖嘟嘟~今天周五呢。啦啦啦啦，恍惚之间，我已经爱你 " + new DateOperator().calculateDate() + " 天啦！<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们将恋爱到时间的尽头，小宝贝儿准备好了么？";
    private static final String SATURDAY = "亲爱的萌胖儿~今天周六啦。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我可以请你看电影吗？别误会，我没别的意思，就是想和你一起起床而已。";
    private static final String SUNDAY = "亲爱的崔胖砸~今天周日呀。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;酒面扑春风，<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;泪眼零秋雨。<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;过了别离时，<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;还解相思否。<br>&nbsp;&nbsp;&nbsp;&nbsp;偶然看到朱生豪的这首情诗，突然觉得自己还得多给你写写练习练习呀~~";

    private static final String WRONG_INDEX = "日期参数 i 传递错误，请联系你的小宝贝儿修复逻辑Bug~~~~么么哒~mua~";

    public String getLuvLetter(int i) {
        switch (i) {
            case 0:
                return MONDAY;
            case 1:
                return TUESDAY;
            case 2:
                return WEDNESDAY;
            case 3:
                return THURSDAY;
            case 4:
                return FRIDAY;
            case 5:
                return SATURDAY;
            case 6:
                return SUNDAY;
        }
        return WRONG_INDEX;
    }
}
