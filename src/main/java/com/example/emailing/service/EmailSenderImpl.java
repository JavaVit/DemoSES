package com.example.emailing.service;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.example.service.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vitaliy on 13.04.2017.
 */
@Service
public class EmailSenderImpl implements EmailSender {

    @Autowired
    AmazonSimpleEmailService amazonSES;

    @Override
    public void sendMail(Email email) {

        // Construct an object to contain the recipient address.
        Destination destination = new Destination().withToAddresses(new String[]{email.getTo()});

        // Create the subject and body of the message.
        Content subject = new Content().withData(email.getSubject());
        Content htmlBody = new Content().withData(email.getBody());
        Body body = new Body().withHtml(htmlBody);

        // Create a message with the specified subject and body.
        Message message = new Message().withSubject(subject).withBody(body);

        // Assemble the email.
        SendEmailRequest request = new SendEmailRequest().withSource(email.getFrom()).withDestination(destination).withMessage(message);

        amazonSES.sendEmail(request);
    }
}