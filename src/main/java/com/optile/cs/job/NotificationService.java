package com.optile.cs.job;

import com.optile.cs.JobSetting;
import com.optile.cs.email.EmailService;
import com.optile.cs.job.model.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

@Service
public class NotificationService {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private EmailService emailService;

    @Autowired
    private JobSetting jobSetting;

    public void sendReport(Weather weather, String recepients)  throws MessagingException {
        Context context = new Context();
        context.setVariable("weather", weather);

        emailService.email(
                recepients,
                "Weather Report : " + weather.getName(),
                templateEngine.process("email", context)
        );
    }
}
