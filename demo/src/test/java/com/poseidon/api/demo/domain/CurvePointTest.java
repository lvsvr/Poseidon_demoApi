package com.poseidon.api.demo.domain;

import com.poseidon.api.demo.repositories.CurvePointRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CurvePointTest {

    private CurvePoint curve0 = new CurvePoint();

    @Autowired
    private CurvePointRepository curveRepo;

    @Test
    void shouldGetCurvePoint(){
//        GIVEN
        curve0.setCurveId(0);
//        WHEN
        curveRepo.save(curve0);
//        THEN
        Assert.assertNotNull(curve0.getId());
        assertEquals(0, curve0.getCurveId());
//        assertEquals("test", bid0.getSecurity());
        Assert.assertNotNull(curve0.toString());


    }
}