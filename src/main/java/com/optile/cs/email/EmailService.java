package com.optile.cs.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void email(String receipents, String subject, String content)  throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        new MimeMessageHelper(mimeMessage, true){{
            setTo(receipents);
            setSubject(subject);
            setText(content, true);
        }};

        javaMailSender.send(mimeMessage);
    }
}
