package model;

import java.util.Date;

public class Reservation {

    private String customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(String customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public IRoom getRoom() {
        return room;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    @Override
    public String toString(){
        return "ThankYou " + customer + " you have Reserved Room Number " + room + " Checking in on " + checkInDate +
        " Checking out on " + checkOutDate;
    }

}
