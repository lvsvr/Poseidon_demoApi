package com.poseidon.api.demo.repositories;

import com.poseidon.api.demo.domain.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepository extends JpaRepository<Trade, Integer> {
}
