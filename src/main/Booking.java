package main;

public class Booking {
    // DEFINE VARIABLES
    private String from;
    private String destination;
    private String time;
    private String phoneNumber;

    // DEFAULT CONSTRUCTOR
    Booking() {

    }

    // PARAMETERIZED CONSTRUCTOR
    public Booking(String from, String destination, String time, String phoneNumber) {
        this.from = from;
        this.destination = destination;
        this.time = time;
        this.phoneNumber = phoneNumber;
    }

    // GET FROM DATA
    public String getFrom() {
        return this.from;
    }

    // GET DESTINATION DATA
    public String getDestination() {
        return this.destination;
    }

    // GET TIME DATA
    public String getTime() {
        return this.time;
    }

    // GET PHONE NUMBER DATA
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
