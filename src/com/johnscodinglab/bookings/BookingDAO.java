package com.johnscodinglab.bookings;

import com.johnscodinglab.car.CarService;

public class BookingDAO {
    private static CarService car = new CarService();
    private static Bookings[] bookings;
    private int numberOfBookings = 0;

    static {
        bookings = new Bookings[car.getCars().length];
    }

    public void saveBooking(Bookings booking) {
        if (numberOfBookings > bookings.length) {
            System.out.println("There are no more cars to book");
        } else {
            bookings[numberOfBookings++] = booking;
            System.out.println("Booked successfully");
        }
    }

    public Bookings[] getBookings() {
        if (numberOfBookings == 0) {
            return new Bookings[0];
        }
        Bookings[] allBookings = new Bookings[numberOfBookings];
        System.arraycopy(bookings, 0, allBookings, 0, numberOfBookings);
        return allBookings;
    }

    public Bookings getBookingsByUserId(String userId) {
        for (int i = 0; i < numberOfBookings; i++) {
            if (bookings[i].getUser().getID().equals(userId)) {
                return bookings[i];
            }
        }
        return null;
    }
}
