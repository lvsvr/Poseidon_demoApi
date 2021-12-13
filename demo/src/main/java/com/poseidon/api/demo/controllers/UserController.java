package com.poseidon.api.demo.controllers;

import com.poseidon.api.demo.DemoApplication;
import com.poseidon.api.demo.config.AppUser;
import com.poseidon.api.demo.domain.User;
import com.poseidon.api.demo.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/user/list")
    public String home(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user/list";
    }


    @GetMapping("/user/add")
    public String addUser(User user) {
        return "user/add";
    }


    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model, @AuthenticationPrincipal AppUser appUser) {
        if (!result.hasErrors()) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
            logger.info(appUser.getUser().getUsername() + " added a new user - Id: " + user.getId() +" - Full Name: " + user.getFullName() + " - Username: " + user.getUsername() + " - Role:" + user.getRole());
            model.addAttribute("users", userRepository.findAll());
            return "redirect:/user/list";
        }
        return "user/add";
    }


    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model, @AuthenticationPrincipal AppUser appUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        user.setPassword("");
        model.addAttribute("user", user);
        logger.info(appUser.getUser().getUsername() + " has selected " + " - Id: " + user.getId() + " - Full Name: " + user.getFullName() + " - Username: " + user.getUsername() + " - Role:" + user.getRole());
        return "user/update";
    }


    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model, @AuthenticationPrincipal AppUser appUser) {
        if (result.hasErrors()) {
            return "user/update";
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setId(id);
        userRepository.save(user);
        logger.info(appUser.getUser().getUsername() + " has updated - Id: " + user.getId() + " - Full Name: " + user.getFullName() + " - Username: " + user.getUsername() + " - Role:" + user.getRole());

        model.addAttribute("users", userRepository.findAll());
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model, @AuthenticationPrincipal AppUser appUser) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        logger.info(appUser.getUser().getUsername() + " has deleted - Id: " + user.getId() + " - Full Name: " + user.getFullName() + " - Username: " + user.getUsername() + " - Role:" + user.getRole());
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/user/list";
    }
}
