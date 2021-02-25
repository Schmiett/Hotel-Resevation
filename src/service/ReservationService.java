package service;

import model.*;

import java.util.*;

public class ReservationService {
    Collection<IRoom> rooms = new HashSet<>();
    Collection<Reservation> reservations = new HashSet<>();
   // Collection<IRoom> unavailableRoomsAccordingToDates = new HashSet<>();

    public void addRoom(String roomNumber, double price, roomType roomType) {
        Room room = new Room(roomNumber, price, roomType);
        rooms.add(room);
    }

    public IRoom getARoom(String roomNumber) {
        for (IRoom room : rooms) {
            if (roomNumber.equals(room.getRoomNumber())) {
                return room;
            }
        }
        return null;
    }

    public  Reservation reserveARoom(String customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }


    public List<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        boolean found = false;
    List<IRoom> findAvailableRooms = new ArrayList<>();
      for(IRoom room : rooms){
          for(Reservation reservation: reservations){
        if((room.getRoomNumber() == reservation.getRoom().getRoomNumber()
        && ((!checkInDate.after(reservation.getCheckInDate()) &&
              !checkInDate.before(reservation.getCheckOutDate())) ||
                (!checkOutDate.after(reservation.getCheckInDate()) &&
              !checkInDate.before(reservation.getCheckOutDate())))) ||
                (!reservation.getRoom().getRoomNumber().contains(room.getRoomNumber()))) {
            findAvailableRooms.add(room);}
        }



      }
    System.out.println(findAvailableRooms);
    return findAvailableRooms;
    }



    public List<Reservation> getCustomersReservation(String customer){
        List<Reservation> reservationsByCustomer = new ArrayList<>();
        for(Reservation reservation : reservations){
            if(reservation.getCustomer().equals(customer)){
                reservationsByCustomer.add(reservation);
            }
        }
        return reservationsByCustomer;
    }
    public Collection<Reservation> getAllReservations(){
        return reservations;
    }
    public Collection<IRoom> allRooms() {
        return rooms;
    }



}
