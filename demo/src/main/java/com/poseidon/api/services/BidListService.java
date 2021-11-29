package com.poseidon.api.services;

import com.poseidon.api.domain.BidList;
import com.poseidon.api.repositories.BidListRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BidListService {

    private final BidListRepository bidListRepository;

    public BidListService(BidListRepository bidListRepository) {
        this.bidListRepository = bidListRepository;
    }

    public ArrayList<BidList> getAllBidList(){
        return (ArrayList<BidList>) bidListRepository.findAll();
    }
}
