package Console;

import api.AdminResource;
import model.Room;
import model.roomType;

import java.util.Scanner;

import static model.roomType.valueOf;

public class AdminMenu {

    public static int navigateToMainMenu = 6;
    public static Scanner input;
    private static AdminResource adminResource;

    public  void display_Menu() {
        System.out.println("Admin Menu");
        System.out.println("1 - All Customer List");
        System.out.println("2 - All Room List");
        System.out.println("3 - All Reservations");
        System.out.println("4 - Add a Room");
        System.out.println("5 - Return to Main");
    }
    public  void addAHotelRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a the Room Number of the Room you wish to Add:");
        String roomID = scanner.next();
        System.out.println("Enter the Room Type Single/Double of the Room");
        roomType roomType = valueOf(scanner.next());
        System.out.println("Enter the Room Price per Night");
        Double roomCost = scanner.nextDouble();

        AdminResource.createRooms(roomID, roomCost, roomType);
    }
    public void startAdmin() {
        input = new Scanner(System.in);
        int selection = 0;


        while (selection != navigateToMainMenu) {


            switch (selection) {
                case 1:
                    System.out.println("You requested All Customers");
                    System.out.println(adminResource.getAllCustomer());
                    break;

                case 2:
                    System.out.println("You requested All Rooms");
                    System.out.println(adminResource.getAllRooms());
                    break;
                case 3:
                    System.out.println("You requested All Reservations");
                    System.out.println(adminResource.getAllReservations());
                    break;
                case 4:
                    System.out.println("Add a room to the Hotel Reservation System");
                    addAHotelRoom();

                case 5:
                    MainMenu.mainMenu();
                   return;


                }
            display_Menu();
            selection = input.nextInt();
            }
        }
}
