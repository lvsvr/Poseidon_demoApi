package com.poseidon.api.demo.controllers;

import com.poseidon.api.demo.DemoApplication;
import com.poseidon.api.demo.domain.Rating;
import com.poseidon.api.demo.services.RatingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class RatingController {

    // TODO: Inject Rating service
    private RatingService ratingService;
    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }


    @RequestMapping("/rating/list")
    public String home(Model model) {
        // TODO: find all Rating, add to model
        ArrayList<Rating> ratings = ratingService.getAllRatings();
        model.addAttribute("ratings", ratings);
        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Rating list
        model.addAttribute("rating", rating);
        if (result.hasErrors()) {
            return "rating/add";
        } else {
            ratingService.addRating(rating);
        }
        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Rating by Id and to model then show to the form
        model.addAttribute("rating", ratingService.getRatingById(id));
        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                               BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Rating and return Rating list
        model.addAttribute("rating", ratingService.getRatingById(id));
        if (result.hasErrors()) {
            return "/rating/update/{id}";
        } else {
            ratingService.updateRating(ratingService.getRatingById(id), rating);
        }
        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Rating by Id and delete the Rating, return to Rating list
        ratingService.deleteRating(ratingService.getRatingById(id));
        return "redirect:/rating/list";
    }
}
