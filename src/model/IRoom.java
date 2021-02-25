package model;

public interface IRoom {
    //This interface will be used to pull data for our system
    public String getRoomNumber();
    public double getRoomPrice();
    public roomType getRoomType();
    public boolean isFree();
}
