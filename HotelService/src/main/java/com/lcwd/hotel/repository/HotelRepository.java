package com.lcwd.hotel.repository;

import com.lcwd.hotel.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {
    @Query("select u FROM Hotel u where u.id = :id")
    public Optional<Hotel> findhotelbyid(@Param("id") String id);
//@Query("select u FROM Hotel u where u.id = :id")
//public Optional<Hotel> findhotelbyid(@Param("id") String id);

}
