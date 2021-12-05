package com.poseidon.api.demo.controllers;

import com.poseidon.api.demo.domain.CurvePoint;
import com.poseidon.api.demo.services.CurveService;
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
public class CurveController {

    // TODO: Inject Curve Point service
    private CurveService curveService;

    public CurveController(CurveService curveService) {
        this.curveService = curveService;
    }

    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        // TODO: find all Curve Point, add to model
        ArrayList<CurvePoint> curves = curveService.getAllCurvePoint();
        model.addAttribute("curves", curves);
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list
        model.addAttribute("curvePoint", curvePoint);
        if (result.hasErrors()){
            return "curvePoint/add";
        }
        else{
            curveService.addCurvePoint(curvePoint);
        }
        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get CurvePoint by Id and to model then show to the form
        model.addAttribute("curvePoint", curveService.getCurvePointById(id));
        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                            BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Curve and return Curve list
        model.addAttribute("curvePoint", curveService.getCurvePointById(id));
        if (result.hasErrors()){
            return "/curvePoint/update/{id}";
        }
        else{
            curveService.updateCurvePoint(curveService.getCurvePointById(id), curvePoint);
        }
        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Curve by Id and delete the Curve, return to Curve list
        curveService.deleteCurvePoint(curveService.getCurvePointById(id));
        return "redirect:/curvePoint/list";
    }
}
