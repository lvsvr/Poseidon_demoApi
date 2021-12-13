package com.poseidon.api.demo.controllers;

import com.poseidon.api.demo.DemoApplication;
import com.poseidon.api.demo.config.AppUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

    @RequestMapping("/")
    public String home(Model model) {
        return "redirect:/bidList/list";
    }

    @RequestMapping("/home")
    public String adminHome(Model model) {
        return "home";
    }

}
