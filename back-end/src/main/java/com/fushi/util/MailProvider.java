package com.fushi.util;

import com.fushi.config.MailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailProvider {
    @Autowired
    private JavaMailSender sender;

    public void sendMail(String email,String code) throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");

        StringBuilder link = new StringBuilder();
        link.append("<a href='http//:localhost:3000/api/auth/active/");
        link.append(code);
        link.append("'>http//:localhost:3000/api/auth/active/");
        link.append(code);
        link.append("</a>");


        String htmlMsg = MailTemplate.EMAIL_CONFIRM_MSG_HEADER+"\n"
                +link.toString()+"\n"
                + MailTemplate.EMAIL_CONFIRM_MSG_FOOTER;
        message.setContent(htmlMsg,"text/html");
        helper.setTo(email);
        helper.setSubject(MailTemplate.SUBJECT);


        sender.send(message);
    }
}
