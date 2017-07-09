package com.summerschool.bookservice.repository;

import com.summerschool.bookservice.beans.Booking;

/**
 * Created by sbabkin on 7/5/2017.
 */
public interface BookingDAO {
    
    Booking getBooking(Long bookingId);
    
    Booking save(Booking booking);
    
    Booking update(Booking booking);
    
    void delete(Booking booking);
    
}
