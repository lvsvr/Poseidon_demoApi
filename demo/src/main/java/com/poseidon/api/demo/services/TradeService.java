package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.Trade;
import com.poseidon.api.demo.repositories.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service JPA
 * @author w-boar
 * @version 1.0
 */

@Service
public class TradeService {
    private final TradeRepository tradeRepository;
    /**
     * @param tradeRepository
     */
    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }
    /**
     * @return ArrayList<Trade>
     */
    public ArrayList<Trade> getAllTrades(){
        return (ArrayList<Trade>) tradeRepository.findAll();
    }
    /**
     * @return Trade
     */
    public Trade addTrade (Trade trade) {
        return tradeRepository.save(trade);
    }
    /**
     * @return Trade
     */
    public Trade getTradeById(Integer id){
        return tradeRepository.getById(id);
    }

    public void updateTrade(Trade trade, Trade updatedTrade){
        trade.setAccount(updatedTrade.getAccount());
        trade.setType(updatedTrade.getType());
        trade.setBuyQuantity(updatedTrade.getBuyQuantity());
        tradeRepository.save(trade);
    }

    public void deleteTrade(Trade trade){
        tradeRepository.delete(trade);
    }

}
