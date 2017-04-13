package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by Vitaliy on 11.04.2017.
 */

@Service
public class MailClient {

    private AmazonSESService amazonSESService;

    @Autowired
    public MailClient(AmazonSESService amazonSESService) {
        this.amazonSESService = amazonSESService;
    }

    public void sendMail(Email email) throws IOException {
        amazonSESService.sendMail(email);
    }

}