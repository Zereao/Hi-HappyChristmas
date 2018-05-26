package com.github.zereao.happy.christmas.configuration;

import com.github.zereao.easyx.mail.MailSender;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.UnsupportedEncodingException;

/**
 * @author Zereao
 * @version 2018/05/24/16:24
 */
@Configuration
@ConfigurationProperties(prefix = "easyx.easy-mail")
public class MailSenderConfig {
    private String host;
    private int smtpPort;
    private String senderAddress;
    private String senderName;
    private String senderPassword;
    private boolean useSSL = false;
    private String sslPort;
    private boolean isDebug = true;

    @Bean
    public MailSender mailSender() {
        MailSender mailSender = new MailSender();
        mailSender.setHost(host);
        mailSender.setSmtpPort(smtpPort);
        mailSender.setSenderAddress(senderAddress);
        mailSender.setSenderName(senderName);
        mailSender.setSenderPassword(senderPassword);
        mailSender.setUseSSL(useSSL);
        mailSender.setSslPort(sslPort);
        mailSender.setDebug(isDebug);
        return mailSender;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getSmtpPort() {
        return smtpPort;
    }

    public void setSmtpPort(int smtpPort) {
        this.smtpPort = smtpPort;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        try {
            this.senderName = new String(senderName.getBytes("GBK"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            this.senderName = senderName;
        }
    }

    public String getSenderPassword() {
        return senderPassword;
    }

    public void setSenderPassword(String senderPassword) {
        this.senderPassword = senderPassword;
    }

    public boolean isUseSSL() {
        return useSSL;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public String getSslPort() {
        return sslPort;
    }

    public void setSslPort(String sslPort) {
        this.sslPort = sslPort;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }
}
