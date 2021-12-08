package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.Trade;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TradeServiceTest {

    @Autowired
    private TradeService underTest;

    private Trade trade1 = new Trade();
    private Trade trade2 = new Trade();

    @Test
    void shouldCRUDTrade(){
//        GIVEN
        trade1.setAccount("account1");
        trade1.setType("type1");
        trade1.setBuyQuantity(12.0);
        trade2.setAccount("account2");
        trade2.setType("type2");
        trade2.setBuyQuantity(14.0);
//        WHEN
        underTest.addTrade(trade1);
        underTest.addTrade(trade2);
//        THEN
// Create
        Assert.assertNotNull(trade1.getTradeId());
        Assert.assertEquals(trade1.getBuyQuantity(), 12.0, 12.0);
// Read
        Assert.assertNotNull(underTest.getTradeById(trade1.getTradeId()));
        Assert.assertNotNull(underTest.getAllTrades());
// Update
//        WHEN
        underTest.updateTrade(trade1, trade2);
//        THEN
        Assert.assertEquals(trade1.getBuyQuantity(), trade2.getBuyQuantity());

    }
}