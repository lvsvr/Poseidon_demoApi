package com.poseidon.api.demo.domain;

import com.poseidon.api.demo.repositories.RatingRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RatingTest {

    private Rating rating0 = new Rating();

    @Autowired
    private RatingRepository ratingRepo;

    @Test
    void shouldGetRating() {
//        GIVEN
        rating0.setMoodysRating("m0");
        rating0.setSandPRating("s0");
        rating0.setFitchRating("f0");
        rating0.setOrderNumber(10);
//        WHEN
        ratingRepo.save(rating0);
//        THEN
        Assert.assertNotNull(rating0.getId());
        assertEquals(10, rating0.getOrderNumber());
        assertEquals("m0", rating0.getMoodysRating());
        assertEquals("s0", rating0.getSandPRating());
        assertEquals("f0", rating0.getFitchRating());
        Assert.assertNotNull(rating0.toString());
    }
}