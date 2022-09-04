package com.email.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {
    Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Value("${gmailHost}")
    private String GMAIL_HOST;

    @Value("${username}")
    private String fromEmail;

    @Value("${password}")
    private String EMAIL_KEY;

    public String getFromValue(){
        return fromEmail;
    }

    public boolean sendMessage (String message, String subject, String to) {
        logger.info("Preparing message");

        boolean isEmailSent = false;

//        message = "Hello, this is my message for mail app";
//        subject = "Confirmation";
//        to = "abhi38020@gmail.com";

        //System Properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", GMAIL_HOST);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication () {
                return new PasswordAuthentication(fromEmail, EMAIL_KEY);
            }
        });
        session.setDebug(true);

        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(fromEmail);
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            logger.info("Sending Message");
//            Transport.send(mimeMessage);
            logger.info("Sent Successfully");
            isEmailSent = true;

        } catch (Exception e) {
            logger.error("Exception in mime field");
            e.printStackTrace();
        }

        return isEmailSent;
    }

}
