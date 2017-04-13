package com.example.service;

import com.example.emailing.service.EmailSender;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

/**
 * Created by Vitaliy on 11.04.2017.
 */
@Log4j2
@Service
public class MailSenderService {

    @Autowired
    private EmailSender emailSender;

    @Autowired
    PrepareEmail prepareEmail;

    //demo
    @Value("${aws.fromEmail}")
    private String fromEmail;
    @Value("${aws.toEmail}")
    private String toEmail;
    @Value("${aws.image1}")
    private String image1;
    @Value("${aws.image2}")
    private String image2;
    @Value("${aws.mailto}")
    private String mailto;
    @Value("${aws.email}")
    private String email;


    public void sendMail() {

        Context context = new Context();
        context.setVariable("title", "Встречай весну с размахом.");
        context.setVariable("description", "Длинное описание");
        context.setVariable("user", "Виталик");
        context.setVariable("image1", image1);
        context.setVariable("image2", image2);
        context.setVariable("mailto", mailto);
        context.setVariable("email", email);

        String body = prepareEmail.getBody(context);

        Email email = Email.builder()
                .from(fromEmail)
                .to(toEmail)
                .body(body)
                .subject("Java test send mail")
                .build();

        emailSender.sendMail(email);
    }
}