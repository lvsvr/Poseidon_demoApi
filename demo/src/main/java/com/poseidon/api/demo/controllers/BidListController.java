package com.poseidon.api.demo.controllers;

import com.poseidon.api.demo.DemoApplication;
import com.poseidon.api.demo.domain.BidList;
import com.poseidon.api.demo.services.BidListService;
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
public class BidListController {
        // TODO: Inject Bid service
    private BidListService bidListService;
    private static final Logger logger = LogManager.getLogger(DemoApplication.class);

    public BidListController(BidListService bidListService) {
        this.bidListService = bidListService;
    }

    @RequestMapping("/bidList/list")
    public String home(Model model)
    {
        // TODO: call service find all bids to show to the view
        ArrayList<BidList> bids = bidListService.getAllBidList();
        model.addAttribute("bids", bids);
        return "bidList/list";
    }

    @GetMapping("/bidList/add")
    public String addBidForm(BidList bid) {
        return "bidList/add";
    }

    @PostMapping("/bidList/validate")
    public String validate(@Valid BidList bid, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return bid list
        model.addAttribute("bidList", bid);
        logger.info(bid.toString());
        if (result.hasErrors()){
            return "bidList/add";
        }
        else{
        bidListService.addBidList(bid);
        }
        return "bidList/add";
    }

    @GetMapping("/bidList/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        // TODO: get Bid by Id and to model then show to the form
        model.addAttribute("bidList", bidListService.getBidListById(id));
        return "bidList/update";
    }

    @PostMapping("/bidList/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid BidList bidList,
                            BindingResult result, Model model) {
        // TODO: check required fields, if valid call service to update Bid and return list Bid
        model.addAttribute("bidList", bidListService.getBidListById(id));
        logger.info(bidList.toString());
        logger.info(bidListService.getBidListById(id));
        if (result.hasErrors()){
            return "bidList/update/{id}";
        }
        else {
            bidListService.updateBidList(bidListService.getBidListById(id), bidList);
        }
        return "redirect:/bidList/list";
    }

    @GetMapping("/bidList/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        // TODO: Find Bid by Id and delete the bid, return to Bid list
        bidListService.deleteBidList(bidListService.getBidListById(id));
        return "redirect:/bidList/list";
    }

}
