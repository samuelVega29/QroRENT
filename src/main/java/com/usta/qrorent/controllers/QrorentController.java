package com.usta.qrorent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QrorentController {

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        model.addAttribute("title", "Tu hogar espera");
        return "home";
    }
}