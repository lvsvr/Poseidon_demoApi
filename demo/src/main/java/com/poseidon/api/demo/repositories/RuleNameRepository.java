package com.poseidon.api.demo.repositories;

import com.poseidon.api.demo.domain.RuleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleNameRepository extends JpaRepository<RuleName, Integer> {
}
