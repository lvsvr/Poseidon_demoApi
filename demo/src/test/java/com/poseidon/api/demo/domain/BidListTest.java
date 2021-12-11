package com.poseidon.api.demo.domain;

import com.poseidon.api.demo.repositories.BidListRepository;
import com.poseidon.api.demo.services.BidListService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BidListTest {

    private BidList bid0 = new BidList();

    @Autowired
    private BidListRepository bidRepo;

    @Test
    void shouldGetBidList() {
//        GIVEN
        bid0.setAccount("a0");
        bid0.setType("t0");
        bid0.setSecurity("test");
        bid0.setBid(10.0);

//        WHEN
        bidRepo.save(bid0);
//        THEN
        Assert.assertNotNull(bid0.getBidListId());
        assertEquals(10.0, bid0.getBid());
        assertEquals("test", bid0.getSecurity());
        Assert.assertNotNull(bid0.toString());
    }


}