package com.summerschool.bookservice.beans;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "booking")
public class Booking {
    private long bookingId;
    private Date startDate;
    private Date endDate;
    private Book book;
    private User holder;

    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booking booking = (Booking) o;

        if (bookingId != booking.bookingId) return false;
        if (startDate != null ? !startDate.equals(booking.startDate) : booking.startDate != null) return false;
        if (endDate != null ? !endDate.equals(booking.endDate) : booking.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bookingId ^ (bookingId >>> 32));
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @ManyToOne
    @JoinColumn(name = "holder_id")
    public User getHolder() {
        return holder;
    }

    public void setHolder(User holder) {
        this.holder = holder;
    }
}
