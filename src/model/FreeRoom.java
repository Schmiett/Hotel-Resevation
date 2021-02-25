package model;

public class FreeRoom extends Room{
    public FreeRoom(String roomNumber, double price, roomType roomType) {
        super(roomNumber, 0, roomType);
    }
    @Override
    public String toString(){
        return "Room Number " + getRoomNumber() + " is a " + getRoomType() + " and is available!";
    }
}
