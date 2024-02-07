# Microservice Project using Spring Boot 3.2.2 and Maven

This project is a microservice architecture built with Spring Boot 3.2.2 and Maven. It consists of three main entities: User, Rating, and Hotel. Each entity has its own database with specific attributes.
In Rating database there is userId and hotelId present and by using this hotel id i can identify user give rating to which hotel.UserService can communicate to HotelService and RatingService by using 
RestTemplete and FeignClient.For FaultTourance used circuitbreaker and Retry.To called the microservice by using it's name used LoadBalance.Used OKTA in ApiGateway service to authenticate.


## Entities

1. **User**
   - Attributes: `userid`, `name`, `email`, `about`
   
2. **Hotel**
   - Attributes: `id`, `name`, `location`, `about`
   
3. **Rating**
   - Attributes: `ratingId`, `hotelId`, `userId`, `rating`, `feedback`

## Components

1. **Service Registry (Eureka)**
   - All microservices are registered here.

2. **User Service Microservice**
   - Utilizes RestTemplate and FeignClient for inter-service communication.
   - Uses LoadBalanced to call microservices by their names instead of port numbers.

3. **API Gateway (Okta)**
   - Responsible for redirecting URLs to the corresponding microservice.
   - Integrates with Okta for authentication.

4. **Config Server**
   - Stores common properties of different entities.

## Technologies Used

- Spring Boot 3.2.2
- Maven
- Eureka (Service Registry)
- RestTemplate and FeignClient
- LoadBalanced
- Okta (API Gateway)
- Config Server

## How to Run

1. Clone the repository.
2. Navigate to the root directory of each microservice.
3. Run `mvn clean install` to build the project.
4. Start each microservice.
5. Access the services through the API Gateway.

## Configuration

- Configure the service ports in each microservice's `application.properties`.
- Set up Okta for authentication in the API Gateway.

## Contributing

Contributions are welcome. Please open an issue to discuss any changes you would like to make.

## License

This project is licensed under the [MIT License](LICENSE).
