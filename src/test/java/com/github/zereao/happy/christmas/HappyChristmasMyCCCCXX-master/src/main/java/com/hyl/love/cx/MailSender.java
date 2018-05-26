package com.hyl.love.cx;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {
    private static Properties prop = CommonUtil.loadProperties();

    public static void sendMail(String subject, String content) throws MessagingException {
        String mailHost = prop.getProperty("mail.host");
        String senderUserName = prop.getProperty("sender.userName");
        String senderUserPassword = prop.getProperty("sender.userPassword");
        Session session = Session.getInstance(prop);
        session.setDebug(true);
        Transport ts = session.getTransport();
        ts.connect(mailHost, senderUserName, senderUserPassword);
        Message message = createSimpleWordMail(session, subject, content);
        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    public static MimeMessage createSimpleWordMail(Session session, String subject, String content) throws MessagingException {
        String senderEmailAddress = prop.getProperty("sender.emailAddress");
        String recipientEmailAddress = prop.getProperty("recipient.emailAddress");
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmailAddress));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmailAddress));
        message.setSubject(subject);
        message.setContent(content, "text/html;charset=UTF-8");
        return message;
    }
}
