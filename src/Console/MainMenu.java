package Console;

import api.HotelResource;
import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    private static final CustomerService customerService = new CustomerService();
    private static final ReservationService reservationService = new ReservationService();
    public static int exitApp = 5;
    public static Scanner input;


    public static void display_Menu() {
        System.out.println("Welcome to CRS Hotels Reservation System");
        System.out.println("1 - Find and reserve a room");
        System.out.println("2 - See my reservations");
        System.out.println("3 - Create an account");
        System.out.println("4 - Admin");
        System.out.println("5 - Exit");

    }
    private static void  viewMyReservation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Email:");
        String email = scanner.next();
        System.out.println(HotelResource.getCustomersReservation(email));
    }
    private static Customer createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Customer Last Name:");
        String lastName = scanner.next();
        System.out.println("Enter Customer Email:");
        String email = scanner.next();

        HotelResource.createACustomer(email, firstName, lastName);
        return new Customer(firstName, lastName, email);

    }
    private static void findAndReserveARoom() {
        //Variables for Room Search
        Date checkOutDate = new Date();
        Date checkInDate = new Date();
        //Converter for going from String to Date
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //Scanner opening
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your Arrival Date in DD/MM/YYYY Format");
        String checkInString = scanner.next();
        //Converting dates
        try {
            checkInDate = formatter.parse(checkInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter Your Check Out Date");
        String checkOutString = scanner.next();
        try {
            checkOutDate = formatter.parse(checkOutString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //////Add in Code here to make reservations once we get an Idea of how it will display
        System.out.println("Available Hotel Rooms for your Days of Travel");
        System.out.println(HotelResource.findARoom(checkInDate , checkOutDate));

        System.out.println("Enter room number: ");
        String roomNumber = scanner.next();
        IRoom room = HotelResource.getRoom(roomNumber);
        System.out.println(room);
        System.out.println(roomNumber);

        System.out.println("Enter customer email: ");
        String email = scanner.next();

        HotelResource.bookARoom(email , room , checkInDate , checkOutDate);
        System.out.println(email + room + checkInDate + checkOutDate);
        System.out.println("Your Reservation has been booked");
       // return HotelResource.findARoom(checkInDate , checkOutDate);
    }




    public static void mainMenu() {
        display_Menu();
        input = new Scanner(System.in);
        int selection = input.nextInt();


        while (selection != exitApp) {


            switch (selection) {
                case 1:
                    //finds and Reserves a room
                    System.out.println("You Selected to make a new Reservation");
                    findAndReserveARoom();

                    break;
                case 2:
                    //Views the customers current reservations
                    System.out.println("You Selected to view your Reservations");
                    viewMyReservation();

                    break;
                case 3:
                    //creates a user account
                    System.out.println("You Selected to Create a new Account");
                    createAccount();

                    break;
                case 4:
                    //switches to admin menu
                    System.out.println("You Selected the Admin Menu");

                    AdminMenu.startAdmin();
                    return;
                case 5:
                    //closes console
                    input.close();
                    System.exit(0);
                default:
                    //User inputs an unexpected choice
                    System.out.println("Incorrect Input");
                    break;
            }
            display_Menu();
            selection = input.nextInt();


        }

    }

    public static void main(String[] args) {
       mainMenu();
    }
}




