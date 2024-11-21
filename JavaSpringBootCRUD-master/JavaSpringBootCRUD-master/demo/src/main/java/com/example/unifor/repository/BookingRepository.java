package com.example.unifor.repository;

import com.example.unifor.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>{
}
