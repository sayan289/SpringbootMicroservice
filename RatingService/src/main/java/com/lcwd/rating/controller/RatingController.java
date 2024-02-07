package com.lcwd.rating.controller;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingservice;
    @PostMapping("/add")
    public Rating add(@RequestBody Rating rating)
    {
        return ratingservice.add(rating);
    }
    @GetMapping("/get")
    public List<Rating> getrating()
    {
        return ratingservice.get();
    }
    @GetMapping("/hotel/{hotelId}")
    public List<Rating> getratingbyhotelid(@PathVariable String hotelId)
    {
        return ratingservice.getRatingByHotelId(hotelId);
    }
    @GetMapping("/user/{userId}")
    public List<Rating> getratingbyuserid(@PathVariable String userId)
    {
        return ratingservice.getRatingByUserId(userId);
    }
}
