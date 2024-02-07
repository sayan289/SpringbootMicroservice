package com.lcwd.user.service.UserService.service;

import com.lcwd.user.service.UserService.entities.Hotel;
import com.lcwd.user.service.UserService.entities.Rating;
import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.external.service.HotelService;
import com.lcwd.user.service.UserService.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
public class userserviceimp implements userservice{
    @Autowired
    UserRepository userrepo;
    @Autowired
    private HotelService hotelService;
    private Logger logger=LoggerFactory.getLogger(userserviceimp.class);
    @Autowired
    private RestTemplate resttemplate;
    public List<User> getuser()
    {

        return userrepo.findAll();
    }
    public User getUseById(String userId){
        User user=userrepo.findById(userId).orElse(null);
        //For Api Calling
        //Getting the Rating of user by api calling and setting that
        String url = "http://RATING-SERVICE/rating/user/" + userId;
        Rating[] ratings = resttemplate.getForObject(url, Rating[].class);
        logger.info("{}", ratings);
        List<Rating> ratingsOfUser = Arrays.stream(ratings).toList();
        //Getting Hotel information and set that
        ratingsOfUser.forEach(rat->{
//            String hotelId=rat.getHotelId();
//            //Calling api to get Hotel by HotelId and
//            String url1 = "http://HOTEL-SERVICE/hotel/get/" + hotelId;
//            ResponseEntity<Hotel> forEntity= resttemplate.getForEntity(url1, Hotel.class);
//            Hotel hotel=forEntity.getBody();
              Hotel hotel=hotelService.getHotel(rat.getHotelId());//return the hotel details for a particular id
              rat.setHotel(hotel);
             // rat.setHotel(hotel);
            //rat.setUserId(user.getUserId());

        });
        user.setRatings(ratingsOfUser);
        //user.setUserId();
        return user;

    }
    public User adduser(User use)
    {
        String randomuserid= UUID.randomUUID().toString();
        use.setUserId(randomuserid);
        return userrepo.save(use);
    }
}
