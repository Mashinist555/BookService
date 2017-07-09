package com.summerschool.bookservice.repository;

import com.summerschool.bookservice.beans.Booking;

public interface BookingDAO {

    Booking getBooking(Long bookingId);

    Booking save(Booking booking);

    Booking update(Booking booking);

    void delete(Booking booking);

}
