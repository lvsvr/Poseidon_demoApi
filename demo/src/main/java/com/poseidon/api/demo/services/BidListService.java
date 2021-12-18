package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.BidList;
import com.poseidon.api.demo.repositories.BidListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service JPA
 * @author w-boar
 * @version 1.0
 */

@Service
public class BidListService {

    private final BidListRepository bidListRepository;
    /**
     * @param bidListRepository
     */
    public BidListService(BidListRepository bidListRepository) {
        this.bidListRepository = bidListRepository;
    }
    /**
     * @return ArrayList<BidList>
     */
    public ArrayList<BidList> getAllBidList() {
        return (ArrayList<BidList>) bidListRepository.findAll();
    }
    /**
     * @return BidList
     */
    public BidList addBidList(BidList bidList) {
        return bidListRepository.save(bidList);
    }
    /**
     * @return BidList
     */
    public BidList getBidListById(Integer id) {
        return bidListRepository.getById(id);
    }

    public void updateBidList(BidList bidList, BidList updatedBidList) {
        bidList.setAccount(updatedBidList.getAccount());
        bidList.setType(updatedBidList.getType());
        bidList.setBidQuantity(updatedBidList.getBidQuantity());
        bidListRepository.save(bidList);
    }

    public void deleteBidList(BidList bidList) {
        bidListRepository.delete(bidList);
    }

}
