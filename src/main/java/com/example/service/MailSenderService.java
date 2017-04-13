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
    MailClient mailClient;

    @Autowired
    PrepareEmail prepareEmail;

    @Value("${aws.fromEmail}")
    private String fromEmail;

    @Value("${aws.toEmail}")
    private String toEmail;


    public void sendMail() {

        Context context = new Context();
        context.setVariable("title", "Встречай весну с размахом.");
        context.setVariable("description", "Длинное описание");
        context.setVariable("user", "Виталик");
        context.setVariable("image2", "https://*********.emailimage/example2.png");
        context.setVariable("image1", "https://*********.emailimage/example1.png");
        context.setVariable("mailto", "mailto:*******@list.ru");
        context.setVariable("email", "********@list.ru");



        String body = prepareEmail.getBody(context);

        Email email = Email.builder()
                .from(fromEmail)
                .to(toEmail)
                .body(body)
                .subject("Java test send mail")
                .build();

//        try {
//            mailClient.sendMail(email);
//        } catch (IOException e) {
//            log.error(e.getMessage(), e);
//        }

        emailSender.sendMail(email);

    }
}