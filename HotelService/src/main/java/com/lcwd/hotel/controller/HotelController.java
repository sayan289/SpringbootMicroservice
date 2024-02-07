package com.lcwd.hotel.controller;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelservice;
    @PostMapping("/add")//adding hotel
    public Hotel add(@RequestBody Hotel hotel)
    {
        return hotelservice.add(hotel);
    }
    @GetMapping("/get")//get all hotel
    public List<Hotel> get()
    {
        return hotelservice.gethotel();
    }
    @GetMapping("/get/{hotelId}")//get a partuclar hotel which has this hotel id
    public Optional<Hotel> gethotelbyid(@PathVariable String hotelId)
    {
        return hotelservice.gethotelby(hotelId);
    }
}
