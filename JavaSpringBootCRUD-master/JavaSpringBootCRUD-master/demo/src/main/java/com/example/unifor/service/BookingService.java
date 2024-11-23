package com.example.unifor.service;

import com.example.unifor.entity.Booking;
import com.example.unifor.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAllBookings(){
        return bookingRepository.findAll();
    }

    public Optional<Booking> findBookingById(Long id){
        return bookingRepository.findById(id);
    }

    public Booking saveBooking(Booking booking){
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking updateBooking){
        return bookingRepository.findById(id)
                .map(booking -> {
                    booking.setNome(updateBooking.getNome());
                    booking.setDateTime(updateBooking.getDateTime());
                    booking.setPossuiCheckin(updateBooking.isPossuiCheckin());
                    booking.setUser(updateBooking.getUser());
                    booking.setPlace(updateBooking.getPlace());
                    return bookingRepository.save(booking);
                }).orElseThrow(() -> new RuntimeException("Booking not found"));
    }

    public void deleteBooking(Long id){
        bookingRepository.deleteById(id);
    }


}
