package com.poseidon.api.demo.repositories;

import com.poseidon.api.demo.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidListRepository extends JpaRepository<BidList, Integer> {
    }
