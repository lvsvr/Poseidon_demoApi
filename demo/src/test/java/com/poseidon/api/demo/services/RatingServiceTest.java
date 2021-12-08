package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.Rating;
import com.poseidon.api.demo.services.RatingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RatingServiceTest {

    @Autowired
    private RatingService underTest;

    private Rating rating1 = new Rating();
    private Rating rating2 = new Rating();

    @Test
    void shouldCRUDRating() {
//        GIVEN
        rating1.setMoodysRating("test1");
        rating2.setMoodysRating("test2");
//        WHEN
        underTest.addRating(rating1);
        underTest.addRating(rating2);
//        THEN
// Create
        Assert.assertNotNull(rating1.getId());
        Assert.assertEquals(rating1.getMoodysRating(), "test1", "test1");
// Read
        Assert.assertNotNull(underTest.getRatingById(rating1.getId()));
        Assert.assertNotNull(underTest.getAllRatings());
// Update
//        WHEN
        underTest.updateRating(rating1, rating2);
//        THEN
        Assert.assertEquals(rating1.getMoodysRating(), rating2.getMoodysRating());
    }

}