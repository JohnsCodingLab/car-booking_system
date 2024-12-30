package com.johnscodinglab.bookings;

import com.johnscodinglab.car.Car;
import com.johnscodinglab.user.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class Bookings {
    private String bookingId;
    private User user;
    private Car car;
    private LocalDateTime bookingTime;
    private boolean isCanceled;

    {
        this.bookingId = UUID.randomUUID().toString();
        this.bookingTime = LocalDateTime.now();
    }

    public Bookings() {
    }

    public Bookings(
            User user, Car car,
            boolean isCanceled) {
        this.user = user;
        this.car = car;
        this.isCanceled = isCanceled;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId='" + bookingId + '\'' +
                ", user=" + user +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                ", isCanceled=" + isCanceled +
                '}';
    }
}
