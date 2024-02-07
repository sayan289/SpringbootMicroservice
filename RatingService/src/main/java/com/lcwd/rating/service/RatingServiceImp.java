package com.lcwd.rating.service;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RatingServiceImp implements RatingService{
    @Autowired
    RatingRepository ratingRepository;
    public Rating add(Rating rating)
    {
        String rid=UUID.randomUUID().toString();//To generate random rating id
        rating.setRatingId(rid);//set this randomhotel id to RatingId.
        return ratingRepository.save(rating);
    }
    public List<Rating> get()
    {
        return ratingRepository.findAll();
    }
    public List<Rating> getRatingByUserId(String userId)
    {
        return ratingRepository.findByUserId(userId);
    }
    public List<Rating> getRatingByHotelId(String hotelId)
    {
        return ratingRepository.findByHotelId(hotelId);
    }
}
