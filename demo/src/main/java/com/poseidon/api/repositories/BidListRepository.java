package com.poseidon.api.repositories;

import com.poseidon.api.domain.BidList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidListRepository extends JpaRepository<BidList, Integer> {
}
