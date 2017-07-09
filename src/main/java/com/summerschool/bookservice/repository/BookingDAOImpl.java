package com.summerschool.bookservice.repository;

import com.summerschool.bookservice.beans.Booking;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookingDAOImpl implements BookingDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Booking getBooking(Long bookingId) {
        return entityManager.find(Booking.class, bookingId);
    }

    @Override
    public Booking save(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    @Override
    public Booking update(Booking booking) {
        return entityManager.merge(booking);
    }

    @Override
    public void delete(Booking booking) {
        entityManager.remove(booking);
    }
}
