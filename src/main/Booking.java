package main;

public class Booking {
    private String from;
    private String destination;
    private String time;
    private String phoneNumber;

    Booking() {

    }

    public Booking(String from, String destination, String time, String phoneNumber) {
        this.from = from;
        this.destination = destination;
        this.time = time;
        this.phoneNumber = phoneNumber;
    }

    public String getFrom() {
        return this.from;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getTime() {
        return this.time;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}
