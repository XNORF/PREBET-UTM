package main;

import java.util.ArrayList;

public class User {
    // DEFINE
    private String matric;
    private String userType; // USER = PASSENGER, USER+ = DRIVER + PASSENGER
    private ArrayList<Booking> bookingList = new ArrayList<Booking>();
    private ArrayList<Booking> bookingAccepted = new ArrayList<Booking>();

    User() {

    }

    // MATRIC AND USER TYPE
    public User(String matric, String userType) {
        this.matric = matric;
        this.userType = userType;
    }

    public String getMatric() {
        return this.matric;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    // PASSENGER
    public void addBooking(Booking booking) {
        this.bookingList.add(booking);
    }

    public ArrayList<Booking> getBookingList() {
        return this.bookingList;
    }

    // DRIVER
    public void addAcceptedBooking(Booking booking) {
        this.bookingAccepted.add(booking);
    }

    public ArrayList<Booking> getAcceptedList() {
        return this.bookingAccepted;
    }
}
