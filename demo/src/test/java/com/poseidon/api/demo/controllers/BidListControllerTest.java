//package com.poseidon.api.demo.controllers;
//
//import com.poseidon.api.demo.config.AppUserService;
//import com.poseidon.api.demo.services.BidListService;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
////@RunWith(SpringJUnit4ClassRunner.class)
////@WebAppConfiguration
////@ContextConfiguration(classes = BidListController.class)
//@WebMvcTest(BidListController.class)
//class BidListControllerTest {
//
////    @Autowired
////    private WebApplicationContext wac;
////    @Autowired
////    private MockMvc mockMvc;
////    @Before
////    public void setup() { this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build(); }
//
//    @MockBean
//    AppUserService appUserService;
//
//
//    @MockBean
//    BidListService bidListService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Test
//    @WithMockUser
//    public void shouldGetBidList() throws Exception {
//        mockMvc.perform(get("/bidList/list"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    @WithMockUser
//    void shouldGetAddBid() throws Exception {
//        mockMvc.perform(get("/bidList/add"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
//
////    @Test
////    @WithMockUser
////    void shouldPostValidate() throws Exception {
////        mockMvc.perform(post("/bidList/validate"))
////                .andDo(print())
////                .andExpect(status().isOk());
////    }
////
////    @Test
////    @WithMockUser
////    void shouldGetUpdateBidList() throws Exception {
////
////        mockMvc.perform(get("/bidList/update/{id}", "id"))
////                .andDo(print())
////                .andExpect(view().name("redirect:/bidList/list"));
////        }
//
//
//}