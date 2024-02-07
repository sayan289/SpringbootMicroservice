package com.lcwd.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}
	//Creatin Api gateway which redirect the api to corresponding microservice
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->
						r.path("/user/**")
								.uri("lb://USER-SERVICE"))
				.route(r->
						r.path("/hotel/**")
								.uri("lb://HOTEL-SERVICE"))
				.route(r->
						r.path("/rating/**")
								.uri("lb://RATING-SERVICE"))
				.build();
	}
}
