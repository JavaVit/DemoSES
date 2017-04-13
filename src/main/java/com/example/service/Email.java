package com.example.service;

import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * Created by Vitaliy on 11.04.2017.
 */
@Log4j2
@Data
@Builder
public class Email {

    private String from; // от кого
    private String to; // кому
    private String body; //сообщение
    private String subject; // тема

}
