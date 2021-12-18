package com.poseidon.api.demo.controllers;

import com.poseidon.api.demo.DemoApplication;
import com.poseidon.api.demo.config.AppUser;
import com.poseidon.api.demo.domain.RuleName;
import com.poseidon.api.demo.services.RuleNameService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class RuleNameController {
    // Inject RuleName service
    private RuleNameService ruleNameService;
    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

    public RuleNameController(RuleNameService ruleNameService) {
        this.ruleNameService = ruleNameService;
    }

    @RequestMapping("/ruleName/list")
    public String home(Model model) {
        // find all RuleName, add to model
        ArrayList<RuleName> ruleNames = ruleNameService.getAllRuleNames();
        model.addAttribute("ruleNames", ruleNames);
        return "ruleName/list";
    }

    @GetMapping("/ruleName/add")
    public String addRuleForm(RuleName bid) {
        return "ruleName/add";
    }

    @PostMapping("/ruleName/validate")
    public String validate(@Valid RuleName ruleName, BindingResult result, Model model, @AuthenticationPrincipal AppUser appUser, Principal oaUser) {
        // check data valid and save to db, after saving return RuleName list
        model.addAttribute("ruleName", ruleName);
        if (result.hasErrors()) {
            return "ruleName/add";
        } else {
            ruleNameService.addRuleName(ruleName);
            if (appUser == null) {
                logger.info(oaUser.toString());
                logger.info("has added a Rule Name - Id: " + ruleName.getId() + " - Name: " + ruleName.getName() + " - Description: " + ruleName.getDescription() + " - json: " + ruleName.getJson() + " - template: " + ruleName.getTemplate() + " - SqlStr: " + ruleName.getSqlStr() + " - SqlPart: " + ruleName.getSqlPart());
            } else {
                logger.info(appUser.getUser().getUsername() + " has added a Rule Name - Id: " + ruleName.getId() + " - Name: " + ruleName.getName() + " - Description: " + ruleName.getDescription() + " - json: " + ruleName.getJson() + " - template: " + ruleName.getTemplate() + " - SqlStr: " + ruleName.getSqlStr() + " - SqlPart: " + ruleName.getSqlPart());
            }
        }
        return "ruleName/add";
    }

    @GetMapping("/ruleName/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // get RuleName by Id and to model then show to the form
        model.addAttribute("ruleName", ruleNameService.getRuleNameById(id));
        return "ruleName/update";
    }

    @PostMapping("/ruleName/update/{id}")
    public String updateRuleName(@PathVariable("id") Integer id, @Valid RuleName updatedRuleName,
                                 BindingResult result, Model model, @AuthenticationPrincipal AppUser appUser, Principal oaUser) {
        //check required fields, if valid call service to update RuleName and return RuleName list
        model.addAttribute("ruleName", ruleNameService.getRuleNameById(id));
        if (result.hasErrors()) {
            return "/ruleName/update/{id}";
        } else {
            RuleName ruleName = ruleNameService.getRuleNameById(id);
            logger.info("Selected Rule Name - Id: " + ruleName.getId() + " - Name: " + ruleName.getName() + " - Description: " + ruleName.getDescription() + " - json: " + ruleName.getJson() + " - template: " + ruleName.getTemplate() + " - SqlStr: " + ruleName.getSqlStr() + " - SqlPart: " + ruleName.getSqlPart());
            ruleNameService.updateRuleName(ruleName, updatedRuleName);
            if (appUser == null) {
                logger.info(oaUser.toString());
                logger.info("has updated a Rule Name - Id: " + ruleName.getId() + " - Name: " + ruleName.getName() + " - Description: " + ruleName.getDescription() + " - json: " + ruleName.getJson() + " - template: " + ruleName.getTemplate() + " - SqlStr: " + ruleName.getSqlStr() + " - SqlPart: " + ruleName.getSqlPart());
            } else {
                logger.info(appUser.getUser().getUsername() + " has updated a Rule Name - Id: " + ruleName.getId() + " - Name: " + ruleName.getName() + " - Description: " + ruleName.getDescription() + " - json: " + ruleName.getJson() + " - template: " + ruleName.getTemplate() + " - SqlStr: " + ruleName.getSqlStr() + " - SqlPart: " + ruleName.getSqlPart());
            }
        }
        return "redirect:/ruleName/list";
    }

    @GetMapping("/ruleName/delete/{id}")
    public String deleteRuleName(@PathVariable("id") Integer id, Model model, @AuthenticationPrincipal AppUser appUser, Principal oaUser) {
        // Find RuleName by Id and delete the RuleName, return to Rule list
        RuleName ruleName = ruleNameService.getRuleNameById(id);
        ruleNameService.deleteRuleName(ruleName);
        if (appUser == null) {
            logger.info(oaUser.toString());
            logger.info("has deleted a Rule Name - Id: " + ruleName.getId() + " - Name: " + ruleName.getName() + " - Description: " + ruleName.getDescription() + " - json: " + ruleName.getJson() + " - template: " + ruleName.getTemplate() + " - SqlStr: " + ruleName.getSqlStr() + " - SqlPart: " + ruleName.getSqlPart());
        } else {
            logger.info(appUser.getUser().getUsername() + " has deleted a Rule Name - Id: " + ruleName.getId() + " - Name: " + ruleName.getName() + " - Description: " + ruleName.getDescription() + " - json: " + ruleName.getJson() + " - template: " + ruleName.getTemplate() + " - SqlStr: " + ruleName.getSqlStr() + " - SqlPart: " + ruleName.getSqlPart());
        }
        return "redirect:/ruleName/list";
    }

}
