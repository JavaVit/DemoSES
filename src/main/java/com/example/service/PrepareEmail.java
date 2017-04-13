package com.example.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by Vitaliy on 11.04.2017.
 */
@Service
@AllArgsConstructor
public class PrepareEmail {

    private TemplateEngine templateEngine;

    public String getBody(Context context) {
        String body = templateEngine.process("email/template-1", context);
        return body;

    }
}
