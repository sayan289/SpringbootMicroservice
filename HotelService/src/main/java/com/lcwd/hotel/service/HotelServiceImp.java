package com.lcwd.hotel.service;

import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class HotelServiceImp implements HotelService{
    @Autowired
    HotelRepository hotelrepository;
    public Hotel add(Hotel hotel)
    {
        String hotelid=UUID.randomUUID().toString();
        hotel.setId(hotelid);
        return hotelrepository.save(hotel);
    }
    public Optional<Hotel> gethotelby(String id)
    {

        //return hotelrepository.findById(hotelid);
        return hotelrepository.findhotelbyid(id);
    }
    public List<Hotel> gethotel()
    {
        return hotelrepository.findAll();
    }
}
