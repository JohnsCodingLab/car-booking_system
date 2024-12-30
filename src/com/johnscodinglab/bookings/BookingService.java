package com.johnscodinglab.bookings;

public class BookingService {
    private final BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public void addBooking(Bookings booking) {
        bookingDAO.saveBooking(booking);
    }

    public Bookings[] getAllBooking() {
        return bookingDAO.getBookings();
    }

    public Bookings getUserBooking(String userID) {
        return bookingDAO.getBookingsByUserId(userID);
    }
}
