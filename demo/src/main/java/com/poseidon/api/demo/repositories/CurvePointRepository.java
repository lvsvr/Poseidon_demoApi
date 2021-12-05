package com.poseidon.api.demo.repositories;

import com.poseidon.api.demo.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {
}
