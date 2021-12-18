package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.CurvePoint;
import com.poseidon.api.demo.repositories.CurvePointRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service JPA
 * @author w-boar
 * @version 1.0
 */

@Service
public class CurveService {

    private final CurvePointRepository curvePointRepository;
    /**
     * @param curvePointRepository
     */
    public CurveService(CurvePointRepository curvePointRepository) {
        this.curvePointRepository = curvePointRepository;
    }
    /**
     * @return ArrayList<CurvePoint>
     */
    public ArrayList<CurvePoint> getAllCurvePoint() {
        return (ArrayList<CurvePoint>) curvePointRepository.findAll();
    }
    /**
     * @return CurvePoint
     */
    public CurvePoint addCurvePoint(CurvePoint curvePoint) {
        return curvePointRepository.save(curvePoint);
    }
    /**
     * @return CurvePoint
     */
    public CurvePoint getCurvePointById(Integer id) {
        return curvePointRepository.getById(id);
    }

    public void updateCurvePoint(CurvePoint curvePoint, CurvePoint updatedCurvePoint) {
        curvePoint.setCurveId(updatedCurvePoint.getCurveId());
        curvePoint.setTerm(updatedCurvePoint.getTerm());
        curvePoint.setValue(updatedCurvePoint.getValue());
        curvePointRepository.save(curvePoint);
    }

    public void deleteCurvePoint(CurvePoint curvePoint) {
        curvePointRepository.delete(curvePoint);
    }
}
