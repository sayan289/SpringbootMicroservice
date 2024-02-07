package com.lcwd.hotel.service;

import com.lcwd.hotel.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface HotelService {
    public Hotel add(Hotel hotel);
    public Optional<Hotel> gethotelby(String hotelid);
    public List<Hotel> gethotel();
}
