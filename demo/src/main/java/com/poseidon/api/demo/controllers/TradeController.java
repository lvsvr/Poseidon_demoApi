package com.poseidon.api.demo.controllers;

import com.poseidon.api.demo.DemoApplication;
import com.poseidon.api.demo.domain.Trade;
import com.poseidon.api.demo.services.TradeService;
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
public class TradeController {
    // TODO: Inject Trade service
    private TradeService tradeService;
    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @RequestMapping("/trade/list")
    public String home(Model model) {
        // TODO: find all Trade, add to model
        ArrayList<Trade> trades = tradeService.getAllTrades();
        model.addAttribute("trades", trades);
        return "trade/list";
    }

    @GetMapping("/trade/add")
    public String addUser(Trade bid) {
        return "trade/add";
    }

    @PostMapping("/trade/validate")
    public String validate(@Valid Trade trade, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Trade list
        model.addAttribute("trade", trade);
        if (result.hasErrors()) {
            return "trade/add";
        } else {
            tradeService.addTrade(trade);
        }
        return "trade/add";
    }

    @GetMapping("/trade/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Trade by Id and to model then show to the form
        model.addAttribute("trade", tradeService.getTradeById(id));
        return "trade/update";
    }

    @PostMapping("/trade/update/{id}")
    public String updateTrade(@PathVariable("id") Integer id, @Valid Trade trade,
                              BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Trade and return Trade list
        model.addAttribute("trade", tradeService.getTradeById(id));
        if (result.hasErrors()) {
            return "/trade/update/{id}";
        } else {
            tradeService.updateTrade(tradeService.getTradeById(id), trade);
        }
        return "redirect:/trade/list";
    }

    @GetMapping("/trade/delete/{id}")
    public String deleteTrade(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Trade by Id and delete the Trade, return to Trade list
        tradeService.deleteTrade(tradeService.getTradeById(id));
        return "redirect:/trade/list";
    }
}
