package com.lcwd.rating.repository;

import com.lcwd.rating.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RatingRepository extends JpaRepository<Rating,String> {
    //List<Rating> findByUserId(String userId);
    @Query("SELECT u FROM Rating u WHERE u.userId = :userId")
    List<Rating> findByUserId(@Param("userId") String userId);

    List<Rating> findByHotelId(String hotelId);
}
