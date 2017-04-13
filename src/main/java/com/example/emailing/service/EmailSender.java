package com.example.emailing.service;

import com.example.emailing.domain.Email;

/**
 * Created by Vitaliy on 13.04.2017.
 */
public interface EmailSender {

    void sendMail(Email email);

}