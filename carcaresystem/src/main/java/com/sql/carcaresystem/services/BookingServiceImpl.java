package com.sql.carcaresystem.services;

import java.util.List;

import com.sql.carcaresystem.models.Booking;
import com.sql.carcaresystem.repositories.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
	private BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBookings() {
        return (List<Booking>) bookingRepository.findAll();
    }

    @Override
    public void addBooking(Booking booking) {
        this.bookingRepository.save(booking);   
    }
}