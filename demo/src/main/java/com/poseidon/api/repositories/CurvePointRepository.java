package com.poseidon.api.repositories;

import com.poseidon.api.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {
}
