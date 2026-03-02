package com.oceanview.resort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * HotelReservationSystem - Main Application Class
 * Ocean View Resort - Galle, Sri Lanka
 * 
 * This system demonstrates all OOP Concepts:
 * - ENCAPSULATION: Private fields with getters/setters
 * - INHERITANCE: Room hierarchy (StandardRoom, DeluxeRoom, Suite)
 * - POLYMORPHISM: Method overriding and overloading
 * - ABSTRACTION: Abstract Room class
 * - AGGREGATION: Reservation contains Guest and Room
 */
public class HotelReservationSystem {
    
    private Authentication auth;
    private Map<String, Reservation> reservations;
    private Map<String, Room> rooms;
    private Scanner scanner;
    private int reservationCounter;
    
    public HotelReservationSystem() {
        this.auth = new Authentication();
        this.reservations = new HashMap<>();
        this.rooms = new HashMap<>();
        this.scanner = new Scanner(System.in);
        this.reservationCounter = 1000;
        initializeRooms();
    }
    
    private void initializeRooms() {
        // Initialize available rooms
        // Standard Rooms (101-110)
        for (int i = 101; i <= 110; i++) {
            rooms.put("S" + i, new StandardRoom(String.valueOf(i)));
        }
        // Deluxe Rooms (201-210)
        for (int i = 201; i <= 210; i++) {
            rooms.put("D" + i, new DeluxeRoom(String.valueOf(i)));
        }
        // Suites (301-305)
        for (int i = 301; i <= 305; i++) {
            rooms.put("U" + i, new Suite(String.valueOf(i)));
        }
    }
    
    public void start() {
        displayWelcomeScreen();
        
        boolean running = true;
        while (running) {
            displayMainMenu();
            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    handleLogin();
                    break;
                case "2":
                    if (checkAuth()) handleAddReservation();
                    break;
                case "3":
                    if (checkAuth()) handleDisplayReservation();
                    break;
                case "4":
                    if (checkAuth()) handleCalculateBill();
                    break;
                case "5":
                    displayHelpMenu();
                    break;
                case "6":
                    running = handleExit();
                    break;
                default:
                    System.out.println("\n✗ Invalid choice! Please try again.");
            }
        }
    }
    
    private void displayWelcomeScreen() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("                                                                    ");
        System.out.println("    ██████  ██████  ███████ ██████  ███    ██ ██    ██ ████████ ██   ██");
        System.out.println("   ██    ██ ██   ██ ██      ██   ██ ████   ██ ██    ██    ██    ██   ██");
        System.out.println("   ██    ██ ██████  █████   ██████  ██ ██  ██ ██    ██    ██    ███████");
        System.out.println("   ██    ██ ██   ██ ██      ██   ██ ██  ██ ██ ██    ██    ██    ██   ██");
        System.out.println("    ██████  ██   ██ ███████ ██   ██ ██   ████  ██████     ██    ██   ██");
        System.out.println("                                                                    ");
        System.out.println("                    V I E W    R E S O R T                          ");
        System.out.println("                                                                    ");
        System.out.println("                      Galle, Sri Lanka                              ");
        System.out.println("                                                                    ");
        System.out.println("=".repeat(70));
        System.out.println("         HOTEL RESERVATION MANAGEMENT SYSTEM v1.0");
        System.out.println("=".repeat(70));
    }
    
    private void displayMainMenu() {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                    MAIN MENU                                │");
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.println("│  1. User Authentication (Login)                             │");
        System.out.println("│  2. Add New Reservation                                     │");
        System.out.println("│  3. Display Reservation Details                             │");
        System.out.println("│  4. Calculate and Print Bill                                │");
        System.out.println("│  5. Help Section                                            │");
        System.out.println("│  6. Exit System                                             │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        if (auth.isLoggedIn()) {
            System.out.println("  [Logged in as: " + auth.getCurrentUser() + "]");
        } else {
            System.out.println("  [Not logged in]");
        }
    }
    
    private void displayHelpMenu() {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                   HELP SECTION                              │");
        System.out.println("├─────────────────────────────────────────────────────────────┤");
        System.out.println("│  1. Login Help                                              │");
        System.out.println("│  2. Add Reservation Help                                    │");
        System.out.println("│  3. View Reservation Help                                   │");
        System.out.println("│  4. Billing Help                                            │");
        System.out.println("│  5. Exit System Help                                        │");
        System.out.println("│  6. OOP Concepts Used                                       │");
        System.out.println("│  7. View All Help                                           │");
        System.out.println("│  0. Back to Main Menu                                       │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        
        System.out.print("\nSelect help topic: ");
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                HelpSection.displayLoginHelp();
                break;
            case "2":
                HelpSection.displayAddReservationHelp();
                break;
            case "3":
                HelpSection.displayViewReservationHelp();
                break;
            case "4":
                HelpSection.displayBillHelp();
                break;
            case "5":
                HelpSection.displayExitHelp();
                break;
            case "6":
                HelpSection.displayOOPConcepts();
                break;
            case "7":
                HelpSection.displayAllHelp();
                break;
            case "0":
                return;
            default:
                System.out.println("\n✗ Invalid choice!");
        }
    }
    
    private void handleLogin() {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                    USER LOGIN                               │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        
        System.out.print("Username: ");
        String username = scanner.nextLine().trim();
        
        System.out.print("Password: ");
        String password = scanner.nextLine().trim();
        
        auth.login(username, password);
    }
    
    private boolean checkAuth() {
        if (!auth.isLoggedIn()) {
            System.out.println("\n✗ Please login first!");
            return false;
        }
        return true;
    }
    
    private void handleAddReservation() {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                 ADD NEW RESERVATION                         │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        
        // Generate reservation number
        String reservationNumber = "RES-" + (++reservationCounter);
        System.out.println("Reservation Number: " + reservationNumber);
        
        // Collect guest details
        System.out.println("\n--- Guest Information ---");
        System.out.print("Guest Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Address: ");
        String address = scanner.nextLine().trim();
        
        System.out.print("Contact Number: ");
        String contact = scanner.nextLine().trim();
        
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        
        String guestId = "GUEST-" + reservationCounter;
        Guest guest = new Guest(guestId, name, address, contact, email);
        
        // Select room type
        System.out.println("\n--- Room Selection ---");
        System.out.println("1. Standard Room - $75.00/night");
        System.out.println("2. Deluxe Room - $120.00/night");
        System.out.println("3. Suite - $250.00/night");
        System.out.print("Select room type (1-3): ");
        
        String roomChoice = scanner.nextLine().trim();
        Room selectedRoom = null;
        String roomPrefix = "";
        
        switch (roomChoice) {
            case "1":
                roomPrefix = "S";
                break;
            case "2":
                roomPrefix = "D";
                break;
            case "3":
                roomPrefix = "U";
                break;
            default:
                System.out.println("✗ Invalid room type!");
                return;
        }
        
        // Find available room
        for (Map.Entry<String, Room> entry : rooms.entrySet()) {
            if (entry.getKey().startsWith(roomPrefix) && entry.getValue().isAvailable()) {
                selectedRoom = entry.getValue();
                selectedRoom.setAvailable(false);
                break;
            }
        }
        
        if (selectedRoom == null) {
            System.out.println("✗ No rooms available for this type!");
            return;
        }
        
        System.out.println("Assigned Room: " + selectedRoom.getRoomNumber());
        
        // Get dates
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate checkIn = null;
        LocalDate checkOut = null;
        
        try {
            System.out.print("\nCheck-in Date (YYYY-MM-DD): ");
            checkIn = LocalDate.parse(scanner.nextLine().trim(), formatter);
            
            System.out.print("Check-out Date (YYYY-MM-DD): ");
            checkOut = LocalDate.parse(scanner.nextLine().trim(), formatter);
            
            if (checkOut.isBefore(checkIn) || checkOut.isEqual(checkIn)) {
                System.out.println("✗ Check-out date must be after check-in date!");
                selectedRoom.setAvailable(true);
                return;
            }
            
            if (checkIn.isBefore(LocalDate.now())) {
                System.out.println("✗ Check-in date cannot be in the past!");
                selectedRoom.setAvailable(true);
                return;
            }
            
        } catch (DateTimeParseException e) {
            System.out.println("✗ Invalid date format! Please use YYYY-MM-DD");
            selectedRoom.setAvailable(true);
            return;
        }
        
        // Create reservation
        Reservation reservation = new Reservation(reservationNumber, guest, selectedRoom, checkIn, checkOut);
        reservations.put(reservationNumber, reservation);
        
        System.out.println("\n✓ Reservation created successfully!");
        System.out.println("\n" + reservation.toString());
    }
    
    private void handleDisplayReservation() {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│              DISPLAY RESERVATION DETAILS                    │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        
        System.out.println("1. Search by Reservation Number");
        System.out.println("2. List All Reservations");
        System.out.print("\nSelect option: ");
        String choice = scanner.nextLine().trim();
        
        switch (choice) {
            case "1":
                System.out.print("\nEnter Reservation Number: ");
                String resNum = scanner.nextLine().trim();
                
                Reservation reservation = reservations.get(resNum);
                if (reservation != null) {
                    System.out.println("\n" + reservation.toString());
                } else {
                    System.out.println("\n✗ Reservation not found!");
                }
                break;
                
            case "2":
                if (reservations.isEmpty()) {
                    System.out.println("\nNo reservations found!");
                } else {
                    System.out.println("\n--- All Reservations ---");
                    for (Reservation res : reservations.values()) {
                        System.out.println("\n" + res.toString());
                        System.out.println();
                    }
                }
                break;
                
            default:
                System.out.println("\n✗ Invalid choice!");
        }
    }
    
    private void handleCalculateBill() {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│               CALCULATE AND PRINT BILL                      │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        
        System.out.print("Enter Reservation Number: ");
        String resNum = scanner.nextLine().trim();
        
        Reservation reservation = reservations.get(resNum);
        if (reservation == null) {
            System.out.println("\n✗ Reservation not found!");
            return;
        }
        
        Bill bill = new Bill(reservation);
        
        // Ask for additional charges
        System.out.print("Add service charges? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            System.out.print("Enter service charges amount: $");
            try {
                double charges = Double.parseDouble(scanner.nextLine().trim());
                bill.setServiceCharges(charges);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount!");
            }
        }
        
        // Ask for discount
        System.out.print("Apply discount? (y/n): ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            System.out.print("Enter discount amount: $");
            try {
                double discount = Double.parseDouble(scanner.nextLine().trim());
                bill.setDiscount(discount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount!");
            }
        }
        
        // Print bill
        System.out.print("Print detailed bill? (y/n): ");
        boolean detailed = scanner.nextLine().trim().equalsIgnoreCase("y");
        bill.printBill(detailed);
        
        System.out.println("\n✓ Bill generated successfully!");
    }
    
    private boolean handleExit() {
        System.out.println("\n┌─────────────────────────────────────────────────────────────┐");
        System.out.println("│                    EXIT SYSTEM                              │");
        System.out.println("└─────────────────────────────────────────────────────────────┘");
        
        System.out.print("Are you sure you want to exit? (y/n): ");
        String confirm = scanner.nextLine().trim();
        
        if (confirm.equalsIgnoreCase("y")) {
            auth.logout();
            System.out.println("\nThank you for using Ocean View Resort Reservation System!");
            System.out.println("Goodbye!\n");
            return false;
        }
        return true;
    }
    
    // Main method
    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem();
        system.start();
    }
}
