package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.BidList;
import com.poseidon.api.demo.repositories.BidListRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BidListServiceTest {

    @Autowired
    private BidListService underTest;

    @Autowired
    private BidListRepository bidRepo;

    private BidList bid1 = new BidList();
    private BidList bid2 = new BidList();


    @Test
    void shouldCRUDBidList() {
//        GIVEN
        bid1.setAccount("account1");
        bid1.setType("type1");
        bid1.setBidQuantity(12.0);
        bid2.setAccount("account2");
        bid2.setType("type2");
        bid2.setBidQuantity(14.0);
//        WHEN
        underTest.addBidList(bid1);
        underTest.addBidList(bid2);
//        THEN
// Create
        Assert.assertNotNull(bid1.getBidListId());
        Assert.assertEquals(bid1.getBidQuantity(), 12d, 12d);
// Read
        Assert.assertNotNull(underTest.getBidListById(bid1.getBidListId()));
        Assert.assertNotNull(underTest.getAllBidList());
// Update
//        WHEN
        underTest.updateBidList(bid1, bid2);
//        THEN
        Assert.assertEquals(bid1.getAskQuantity(), bid2.getAskQuantity());
// Delete
//        WHEN
        underTest.deleteBidList(bid2);
//        THEN
        assertFalse(underTest.getAllBidList().contains(bid2));

    }
}