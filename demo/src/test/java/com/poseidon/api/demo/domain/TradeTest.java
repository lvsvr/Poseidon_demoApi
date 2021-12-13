package com.poseidon.api.demo.domain;

import com.poseidon.api.demo.repositories.TradeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TradeTest {

    private Trade trade0 = new Trade();

    @Autowired
    private TradeRepository tradeRepo;

    @Test
    void shouldGetTrade() {
//        GIVEN
        trade0.setAccount("a0");
        trade0.setType("t0");
        trade0.setSecurity("test");
        trade0.setBuyQuantity(10.0);
        //        WHEN
        tradeRepo.save(trade0);
//        THEN
        Assert.assertNotNull(trade0.getTradeId());
        assertEquals(10.0, trade0.getBuyQuantity());
        assertEquals("test", trade0.getSecurity());
        Assert.assertNotNull(trade0.toString());
    }
}
