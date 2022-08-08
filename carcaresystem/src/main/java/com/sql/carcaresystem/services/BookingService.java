package com.sql.carcaresystem.services;

import java.util.List;

import com.sql.carcaresystem.models.Booking;

public interface BookingService {
    List<Booking> getAllBookings();
	void addBooking(Booking booking);
}
