package com.poseidon.api.demo.controllers;

import com.poseidon.api.demo.DemoApplication;
import com.poseidon.api.demo.domain.RuleName;
import com.poseidon.api.demo.services.RuleNameService;
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
public class RuleNameController {
    // TODO: Inject RuleName service
    private RuleNameService ruleNameService;
    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

    public RuleNameController(RuleNameService ruleNameService) {
        this.ruleNameService = ruleNameService;
    }

    @RequestMapping("/ruleName/list")
    public String home(Model model) {
        // TODO: find all RuleName, add to model
        ArrayList<RuleName> ruleNames = ruleNameService.getAllRuleNames();
        model.addAttribute("ruleNames", ruleNames);
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return RuleName list
        model.addAttribute("ruleName", ruleName);
        if (result.hasErrors()) {
            return "ruleName/add";
        } else {
            ruleNameService.addRuleName(ruleName);
        }
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get RuleName by Id and to model then show to the form
        model.addAttribute("ruleName", ruleNameService.getRuleNameById(id));
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName ruleName,
                                 BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update RuleName and return RuleName list
        model.addAttribute("ruleName", ruleNameService.getRuleNameById(id));
        if (result.hasErrors()) {
            return "/ruleName/update/{id}";
        } else {
            ruleNameService.updateRuleName(ruleNameService.getRuleNameById(id), ruleName);
        }
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model) {
        // TODO: Find RuleName by Id and delete the RuleName, return to Rule list
        ruleNameService.deleteRuleName(ruleNameService.getRuleNameById(id));
        return "redirect:/ruleName/list";
    }

}
