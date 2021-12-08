package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.CurvePoint;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class CurveServiceTest {

    @Autowired
    private CurveService underTest;

    private CurvePoint curve1 = new CurvePoint();
    private CurvePoint curve2 = new CurvePoint();

    @Test
    void shouldCRUDCurve() {
//        GIVEN
        curve1.setCurveId(1);
        curve1.setTerm(12.0);
        curve1.setValue(12.0);
        curve2.setCurveId(2);
        curve2.setTerm(14.0);
        curve2.setValue(14.0);
//        WHEN
        underTest.addCurvePoint(curve1);
        underTest.addCurvePoint(curve2);
//        THEN
// Create
        Assert.assertNotNull(curve1.getCurveId());
        Assert.assertEquals(curve1.getValue(), 12.0, 12.0);
// Read
        Assert.assertNotNull(underTest.getCurvePointById(curve1.getId()));
        Assert.assertNotNull(underTest.getAllCurvePoint());
// Update
//        WHEN
        underTest.updateCurvePoint(curve1, curve2);
//        THEN
        Assert.assertEquals(curve1.getValue(), curve2.getValue());
// Delete
//        WHEN
        underTest.deleteCurvePoint(curve2);
//        THEN
        assertFalse(underTest.getAllCurvePoint().contains(curve2));
    }
}