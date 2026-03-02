package com.oceanview.resort;

/**
 * HelpSection class provides guidelines for staff
 * Contains documentation on how to use the system
 */
public class HelpSection {
    
    public static void displayMainMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              OCEAN VIEW RESORT - USER GUIDE");
        System.out.println("=".repeat(60));
        System.out.println();
        System.out.println("WELCOME TO THE HOTEL RESERVATION SYSTEM");
        System.out.println("This system helps you manage room reservations efficiently.");
        System.out.println();
        System.out.println("┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  SYSTEM OVERVIEW                                        │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│  This computerized system handles:                      │");
        System.out.println("│  • Guest registration and management                    │");
        System.out.println("│  • Room reservations and availability                   │");
        System.out.println("│  • Billing and invoicing                                │");
        System.out.println("│  • Secure user authentication                           │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }
    
    public static void displayLoginHelp() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  1. USER AUTHENTICATION (LOGIN)                         │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│  Purpose: Secure access to the reservation system       │");
        System.out.println("│                                                         │");
        System.out.println("│  How to Login:                                          │");
        System.out.println("│  1. Select option '1' from the main menu                │");
        System.out.println("│  2. Enter your username                                 │");
        System.out.println("│  3. Enter your password (characters are hidden)         │");
        System.out.println("│  4. Press Enter to submit                               │");
        System.out.println("│                                                         │");
        System.out.println("│  Default Accounts:                                      │");
        System.out.println("│  • admin / admin123       - Full system access          │");
        System.out.println("│  • manager / manager123   - Management functions        │");
        System.out.println("│  • receptionist / reception123 - Front desk access      │");
        System.out.println("│  • staff / staff123       - Basic reservation access    │");
        System.out.println("│                                                         │");
        System.out.println("│  Security Notes:                                        │");
        System.out.println("│  • Maximum 3 login attempts allowed                     │");
        System.out.println("│  • Account locks after failed attempts                  │");
        System.out.println("│  • Contact manager to reset password                    │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }
    
    public static void displayAddReservationHelp() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  2. ADD NEW RESERVATION                                 │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│  Purpose: Register a new guest and create booking       │");
        System.out.println("│                                                         │");
        System.out.println("│  Required Information:                                  │");
        System.out.println("│  • Reservation Number - Unique ID (auto-generated)      │");
        System.out.println("│  • Guest Name - Full name of the guest                  │");
        System.out.println("│  • Address - Complete residential address               │");
        System.out.println("│  • Contact Number - Phone number with country code      │");
        System.out.println("│  • Email - Valid email address (optional)               │");
        System.out.println("│  • Room Type - Standard / Deluxe / Suite                │");
        System.out.println("│  • Check-in Date - Format: YYYY-MM-DD                   │");
        System.out.println("│  • Check-out Date - Must be after check-in date         │");
        System.out.println("│                                                         │");
        System.out.println("│  Room Types & Rates:                                    │");
        System.out.println("│  • Standard Room  - $75.00/night (Single/Double bed)    │");
        System.out.println("│  • Deluxe Room    - $120.00/night (Ocean view, balcony) │");
        System.out.println("│  • Suite          - $250.00/night (Premium amenities)   │");
        System.out.println("│                                                         │");
        System.out.println("│  Steps:                                                 │");
        System.out.println("│  1. Select option '2' from main menu                    │");
        System.out.println("│  2. Enter guest details as prompted                     │");
        System.out.println("│  3. Select room type (1-3)                              │");
        System.out.println("│  4. Enter dates in YYYY-MM-DD format                    │");
        System.out.println("│  5. Confirm reservation details                         │");
        System.out.println("│  6. System generates reservation number                 │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }
    
    public static void displayViewReservationHelp() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  3. DISPLAY RESERVATION DETAILS                         │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│  Purpose: Retrieve and view booking information         │");
        System.out.println("│                                                         │");
        System.out.println("│  How to Use:                                            │");
        System.out.println("│  1. Select option '3' from main menu                    │");
        System.out.println("│  2. Enter the reservation number                        │");
        System.out.println("│  3. System displays complete booking details            │");
        System.out.println("│                                                         │");
        System.out.println("│  Information Displayed:                                 │");
        System.out.println("│  • Guest name and contact details                       │");
        System.out.println("│  • Room type and assigned room number                   │");
        System.out.println("│  • Check-in and check-out dates                         │");
        System.out.println("│  • Number of nights and total amount                    │");
        System.out.println("│  • Room amenities                                       │");
        System.out.println("│  • Reservation status (Active/Cancelled)                │");
        System.out.println("│                                                         │");
        System.out.println("│  Tips:                                                  │");
        System.out.println("│  • Reservation numbers are case-sensitive               │");
        System.out.println("│  • Use 'List All' to see all active reservations        │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }
    
    public static void displayBillHelp() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  4. CALCULATE AND PRINT BILL                            │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│  Purpose: Generate invoice for guest checkout           │");
        System.out.println("│                                                         │");
        System.out.println("│  How to Use:                                            │");
        System.out.println("│  1. Select option '4' from main menu                    │");
        System.out.println("│  2. Enter reservation number                            │");
        System.out.println("│  3. System calculates total charges                     │");
        System.out.println("│  4. Bill is displayed and can be printed                │");
        System.out.println("│                                                         │");
        System.out.println("│  Bill Components:                                       │");
        System.out.println("│  • Room Charges - Nights × Rate per night               │");
        System.out.println("│  • Service Charges - Additional services (if any)       │");
        System.out.println("│  • Discounts - Promotional discounts (if applicable)    │");
        System.out.println("│  • Subtotal - Sum of all charges                        │");
        System.out.println("│  • Tax (15%) - Government tax on subtotal               │");
        System.out.println("│  • Grand Total - Final amount to be paid                │");
        System.out.println("│                                                         │");
        System.out.println("│  Payment Options:                                       │");
        System.out.println("│  • Cash                                                 │");
        System.out.println("│  • Credit/Debit Card                                    │");
        System.out.println("│  • Bank Transfer                                        │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }
    
    public static void displayExitHelp() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  6. EXIT SYSTEM                                         │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│  Purpose: Safely close the application                  │");
        System.out.println("│                                                         │");
        System.out.println("│  How to Use:                                            │");
        System.out.println("│  1. Select option '6' from main menu                    │");
        System.out.println("│  2. System confirms logout if user is logged in         │");
        System.out.println("│  3. Application closes safely                           │");
        System.out.println("│                                                         │");
        System.out.println("│  Important:                                             │");
        System.out.println("│  • Always logout properly to protect data               │");
        System.out.println("│  • Unsaved data may be lost if force-closed             │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }
    
    public static void displayOOPConcepts() {
        System.out.println("\n┌─────────────────────────────────────────────────────────┐");
        System.out.println("│  OOP CONCEPTS USED IN THIS SYSTEM                       │");
        System.out.println("├─────────────────────────────────────────────────────────┤");
        System.out.println("│  1. ENCAPSULATION                                       │");
        System.out.println("│     • All classes use private fields                    │");
        System.out.println("│     • Public getters/setters control access             │");
        System.out.println("│     • Data hiding and protection                        │");
        System.out.println("│     • Example: Guest class with private details         │");
        System.out.println("│                                                         │");
        System.out.println("│  2. INHERITANCE                                         │");
        System.out.println("│     • Room is abstract parent class                     │");
        System.out.println("│     • StandardRoom, DeluxeRoom, Suite extend Room       │");
        System.out.println("│     • Code reuse and hierarchy                          │");
        System.out.println("│                                                         │");
        System.out.println("│  3. POLYMORPHISM                                        │");
        System.out.println("│     • Method overriding in room types                   │");
        System.out.println("│     • Different rates for each room type                │");
        System.out.println("│     • Method overloading in Bill class                  │");
        System.out.println("│                                                         │");
        System.out.println("│  4. ABSTRACTION                                         │");
        System.out.println("│     • Room is abstract class                            │");
        System.out.println("│     • Hides implementation details                      │");
        System.out.println("│     • Exposes only necessary functionality              │");
        System.out.println("│                                                         │");
        System.out.println("│  5. AGGREGATION                                         │");
        System.out.println("│     • Reservation contains Guest and Room               │");
        System.out.println("│     • Objects work together as whole                    │");
        System.out.println("└─────────────────────────────────────────────────────────┘");
    }
    
    public static void displayAllHelp() {
        displayMainMenu();
        displayLoginHelp();
        displayAddReservationHelp();
        displayViewReservationHelp();
        displayBillHelp();
        displayExitHelp();
        displayOOPConcepts();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("              END OF HELP DOCUMENTATION");
        System.out.println("=".repeat(60));
    }
}
