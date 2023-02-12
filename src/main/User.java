package main;

import java.util.ArrayList;

public class User {
    // DEFINE
    private String matric;
    private String userType; // USER = PASSENGER, USER+ = DRIVER + PASSENGER

    // BOOKING LIST = PASSENGER, BOOKING ACCEPTED = DRIVER ACCEPTED LIST
    private ArrayList<Booking> bookingList = new ArrayList<Booking>();
    private ArrayList<Booking> bookingAccepted = new ArrayList<Booking>();

    // DEFAULT CONSTRUCTOR
    User() {

    }

    // MATRIC AND USER TYPE
    // PARAMETERIZED CONSTRUCTOR
    public User(String matric, String userType) {
        this.matric = matric;
        this.userType = userType;
    }

    // RETURN MATRIC
    public String getMatric() {
        return this.matric;
    }

    // RETURN USER TYPE
    public String getUserType() {
        return this.userType;
    }

    // SET USER TYPE
    public void setUserType(String userType) {
        this.userType = userType;
    }

    // PASSENGER (ADD BOOKING + GET BOOKING LIST)
    public void addBooking(Booking booking) {
        this.bookingList.add(booking);
    }

    public ArrayList<Booking> getBookingList() {
        return this.bookingList;
    }

    // DRIVER (ADD ACCEPTED BOOKING + GET ACCEPTED BOOKING LIST)
    public void addAcceptedBooking(Booking booking) {
        this.bookingAccepted.add(booking);
    }

    public ArrayList<Booking> getAcceptedList() {
        return this.bookingAccepted;
    }
}
