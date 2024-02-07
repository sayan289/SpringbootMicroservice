package com.lcwd.user.service.UserService.external.service;

import com.lcwd.user.service.UserService.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotel/get/{hotelId}")
    Hotel getHotel(@PathVariable String hotelId);
}
