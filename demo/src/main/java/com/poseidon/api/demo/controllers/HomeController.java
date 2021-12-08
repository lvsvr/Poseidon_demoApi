package com.poseidon.api.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model)
    {
        return "redirect:/bidList/list";
    }

    @RequestMapping("/home")
    public String adminHome(Model model)
    {
        return "home";
    }

}
