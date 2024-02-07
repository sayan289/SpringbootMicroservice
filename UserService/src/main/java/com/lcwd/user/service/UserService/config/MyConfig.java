package com.lcwd.user.service.UserService.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean
    @LoadBalanced//To call the service with it's name instead of localhost:port number
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
