package model;

public class Room implements IRoom{
   private String roomNumber;
   private double price;
   private roomType roomType;

   public Room(String roomNumber, double price, roomType roomType){
       this.roomNumber = roomNumber;
       this.price   =   price;
       this.roomType = roomType;

   }




    public String getRoomNumber() {
       return roomNumber;
    }
    public void setRoomNumber(){
       this.roomNumber = roomNumber;
    }

    public double getRoomPrice() {
       return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public model.roomType getRoomType() {
        return roomType;
    }

    public void setRoomType(roomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }
    @Override
    public String toString(){
       return "Room " + roomNumber + " Is a " + roomType + " room and costs" + price + " per night.";
    }


}
