package com.lcwd.user.service.UserService.controller;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.service.userservice;
import com.lcwd.user.service.UserService.service.userserviceimp;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class usercontroller {
    private Logger logger= LoggerFactory.getLogger(usercontroller.class);
    @Autowired
    userservice userservice;
    @PostMapping("/add")
    public User adduser(@RequestBody User use)
    {
       return userservice.adduser(use);
    }
    @GetMapping("/all")
    public List<User> getuser()
    {
        return userservice.getuser();
    }
    int retrycount=1;
    @GetMapping("/all/{userId}")
    //@CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratinghotelFallback")//If the dependend micro service is off then it return dummy user.
    @Retry(name="ratingHotelBreaker",fallbackMethod = "ratinghotelFallback")//Called the dependend service for a particular number of time if the service not response then it return dummy user
    public User getuserbyid(@PathVariable String userId)
    {
        logger.info("Retry count {}",retrycount);
        retrycount++;
        return userservice.getUseById(userId);

    }
    public User ratinghotelFallback(String userId,Exception ex)
    {
        logger.info("Fallback executed",ex.getMessage());
        User user1=new User();
        user1.setUserId("Dummy");
        user1.setName("Dummy");
        user1.setEmail("dummy123");
        user1.setAbout("service is down");
        return user1;
    }
}
