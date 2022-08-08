package com.sql.carcaresystem.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

import com.sql.carcaresystem.models.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {

    @Query (value = "SELECT b from Booking b where b.bookingDate = ?1 and b.bookingTimeSlot = ?2 and b.bookingBranch = ?3 and b.staffID = ?4")
    List<Booking> getBookingsByDateTimeBranch(Date date, String time, Integer branch, Integer staff);

    @Query (value = "SELECT COUNT(b) from Booking b where b.bookingDate = ?1 and b.bookingTimeSlot = ?2 and b.bookingBranch = ?3")
    Integer getCountByDateTimeBranch(Date date, String time, Integer branch);

}
