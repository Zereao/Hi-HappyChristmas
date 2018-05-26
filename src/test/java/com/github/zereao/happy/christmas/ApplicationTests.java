package com.github.zereao.happy.christmas;

import com.github.zereao.happy.christmas.configuration.MailSenderConfig;
import com.github.zereao.happy.christmas.service.MailSendService;
import com.github.zereao.happy.christmas.service.SpiderService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.mail.EmailException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties(MailSenderConfig.class)
public class ApplicationTests {

    @Autowired
    private MailSendService mailSendService;
    @Autowired
    private SpiderService spiderService;

    @Test
    public void test3() throws ParseException {
        String a = "2018052608";
        System.out.println(Long.parseLong(a));
        new SimpleDateFormat("yyyyMMddHH").parse(a);
//        Date s = sdf.parse(a);
//        System.out.println(s);
    }

    @Test
    public void test2() throws IOException {
        try {
            JSONObject jsonArray = spiderService.weatherSpider("101121001");
            System.out.println(jsonArray.toString(2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void contextLoads() throws EmailException {
        mailSendService.sendMail();
    }

}
