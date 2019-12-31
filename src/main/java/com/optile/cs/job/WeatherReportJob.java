package com.optile.cs.job;

import com.optile.cs.client.Job;
import com.optile.cs.error.JobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class WeatherReportJob extends Job {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private NotificationService notificationService;

    @Override
    protected void process(String jobId, String... args) throws JobException {
        try {
            notificationService
                    .sendReport(weatherService.getWeatherData(args[1]), args[2]);
        } catch (MessagingException messagingException) {
            throw new JobException(messagingException.getMessage());
        }
    }
}
