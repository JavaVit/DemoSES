package com.example.web.controller;

import com.example.service.MailSenderService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vitaliy on 11.04.2017.
 */
@Log4j2
@Controller
@RequestMapping({"/"})
public class IndexController {

    @Autowired
    private MailSenderService mailSenderService;

    @GetMapping
    public String start() {
        return "redirect:index";
    }

    @GetMapping({"index"})
    public String index(Model model) {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        model.addAttribute("name", path);
        return "index";
    }

    @GetMapping({"mail"})
    public String mail(Model model) {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        model.addAttribute("name", path);
        return "mail";
    }

    @GetMapping({"sendmail"})
    public String sendMail(Model model) {
        log.info("send mail");


        mailSenderService.sendMail();



        return "index";
    }

}