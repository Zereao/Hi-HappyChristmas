package com.github.zereao.happy.christmas.service;

import com.github.zereao.easyx.mail.MailDTO;
import com.github.zereao.easyx.mail.MailSender;
import com.github.zereao.happy.christmas.configuration.MailSenderConfig;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zereao
 * @version 2018/05/24/16:37
 */
@Service
@EnableConfigurationProperties(MailSenderConfig.class)
public class MailSendService {
    private final MailSender mailSender;

    @Autowired
    public MailSendService(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail() throws EmailException, ParseException {
        MailDTO mailDTO = new MailDTO();
        mailDTO.setSubject("从开始到忘记，这是第" + calculateDate() + "个天晴。微笑。");
        mailDTO.setRecipients("1050214520@qq.com");
        mailDTO.setContent("这到底是什么回事呢？第一次测试的结果呢，请查阅哦，居然发不出去？");
        mailSender.simpleMailSender(mailDTO);
    }

    private long calculateDate() throws ParseException {
        final String loveDate = "2014-05-17";
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date love = sdf.parse(loveDate);
        return (now.getTime() - love.getTime()) / 86400000L;
    }

}
