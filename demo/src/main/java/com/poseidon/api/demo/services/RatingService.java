package com.poseidon.api.demo.services;

import com.poseidon.api.demo.domain.Rating;
import com.poseidon.api.demo.repositories.RatingRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service JPA
 * @author w-boar
 * @version 1.0
 */

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    /**
     * @param ratingRepository
     */
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
    /**
     * @return ArrayList<Rating>
     */
    public ArrayList<Rating> getAllRatings(){
        return (ArrayList<Rating>) ratingRepository.findAll();
    }
    /**
     * @return Rating
     */
    public Rating addRating(Rating rating){
        return ratingRepository.save(rating);
    }
    /**
     * @return Rating
     */
    public Rating getRatingById(Integer id){
        return ratingRepository.getById(id);
    }

    public void updateRating(Rating rating, Rating updatedRating){
        rating.setMoodysRating(updatedRating.getMoodysRating());
        rating.setSandPRating(updatedRating.getSandPRating());
        rating.setFitchRating(updatedRating.getFitchRating());
        rating.setOrderNumber(updatedRating.getOrderNumber());
        ratingRepository.save(rating);
    }

    public void deleteRating (Rating rating){
        ratingRepository.delete(rating);
    }
}
