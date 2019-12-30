package com.optile.cs.job;

import com.optile.cs.client.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class WeatherReportJob extends Job {
    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    protected void process(String jobId) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("anant.c.pawar@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
    }
}
