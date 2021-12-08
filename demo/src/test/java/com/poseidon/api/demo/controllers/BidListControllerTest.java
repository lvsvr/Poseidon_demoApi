//package com.poseidon.api.demo.controllers;
//
//import com.poseidon.api.demo.services.BidListService;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(BidListController.class)
//class BidListControllerTest {
//
//    @MockBean
//    BidListService bidListService;
//
//    @MockBean
//    MockMvc mockMvc;
//
//    @Test
//    void home() throws Exception {
//        mockMvc.perform(get("/bidList/list"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void addBidForm() {
//    }
//
//    @Test
//    void validate() {
//    }
//
//    @Test
//    void showUpdateForm() {
//    }
//
//    @Test
//    void updateBid() {
//    }
//
//    @Test
//    void deleteBid() {
//    }
//}