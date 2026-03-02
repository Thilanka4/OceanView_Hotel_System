# Ocean View Resort - Hotel Reservation System

## Overview
A comprehensive Java-based Hotel Reservation Management System for Ocean View Resort in Galle, Sri Lanka. This system efficiently handles room reservations, guest management, billing, and user authentication.

## Features

### 1. User Authentication (Login)
- Secure username/password authentication
- Multiple user roles (admin, manager, receptionist, staff)
- Account lockout after 3 failed attempts
- Password management capabilities

### 2. Add New Reservation
- Guest registration with complete details
- Room type selection (Standard, Deluxe, Suite)
- Automatic room assignment
- Date validation
- Unique reservation number generation

### 3. Display Reservation Details
- Search by reservation number
- List all active reservations
- Complete booking information display

### 4. Calculate and Print Bill
- Automatic cost calculation based on nights and room rates
- Service charges and discount support
- Tax calculation (15%)
- Professional bill printing

### 5. Help Section
- Comprehensive user guide
- Instructions for all features
- OOP concepts documentation

### 6. Exit System
- Safe logout and application closure

## OOP Concepts Implemented

### 1. ENCAPSULATION
- All classes use private fields
- Public getters/setters for controlled access
- Data hiding and protection
- Example: `Guest` class with private personal details

```java
public class Guest {
    private String guestId;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    
    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
```

### 2. INHERITANCE
- `Room` is an abstract parent class
- `StandardRoom`, `DeluxeRoom`, and `Suite` extend `Room`
- Code reuse and hierarchical organization

```java
public abstract class Room {
    protected String roomNumber;
    protected boolean isAvailable;
    
    public abstract double getRatePerNight();
}

public class DeluxeRoom extends Room {
    @Override
    public double getRatePerNight() {
        return 120.00;
    }
}
```

### 3. POLYMORPHISM
- Method overriding in room types (different rates)
- Method overloading in `Bill` class
- Dynamic method dispatch

```java
// Method Overriding
public class Suite extends Room {
    @Override
    public double getRatePerNight() {
        return 250.00;  // Different implementation
    }
}

// Method Overloading
public void printBill() { }
public void printBill(boolean detailed) { }
```

### 4. ABSTRACTION
- Abstract `Room` class hides implementation details
- Exposes only necessary functionality
- Common interface for all room types

```java
public abstract class Room {
    public abstract double getRatePerNight();
    public abstract String getRoomType();
    public abstract String getAmenities();
}
```

### 5. AGGREGATION
- `Reservation` contains `Guest` and `Room` objects
- Objects work together as a whole
- Has-a relationship

```java
public class Reservation {
    private Guest guest;    // Aggregation
    private Room room;      // Aggregation
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
```

## Project Structure

```
OceanViewResort/
├── src/
│   └── com/
│       └── oceanview/
│           └── resort/
│               ├── HotelReservationSystem.java  (Main Class)
│               ├── Authentication.java           (Login System)
│               ├── Guest.java                    (Guest Details)
│               ├── Room.java                     (Abstract Room)
│               ├── StandardRoom.java             (Standard Room)
│               ├── DeluxeRoom.java               (Deluxe Room)
│               ├── Suite.java                    (Suite)
│               ├── Reservation.java              (Booking Details)
│               ├── Bill.java                     (Billing System)
│               └── HelpSection.java              (User Guide)
├── README.md
└── compile.sh
```

## Room Types and Rates

| Room Type | Rate per Night | Amenities |
|-----------|----------------|-----------|
| Standard Room | $75.00 | Single/Double Bed, TV, AC, WiFi, Mini Fridge |
| Deluxe Room | $120.00 | King Bed, Ocean View, Smart TV, AC, WiFi, Mini Bar, Balcony |
| Suite | $250.00 | Master Bedroom, Living Room, Ocean View, 2 Smart TVs, Jacuzzi, Kitchenette, Butler Service, Private Terrace |

## Default Login Credentials

| Username | Password | Role |
|----------|----------|------|
| admin | admin123 | Full system access |
| manager | manager123 | Management functions |
| receptionist | reception123 | Front desk access |
| staff | staff123 | Basic reservation access |

## How to Compile and Run

### Compile
```bash
cd OceanViewResort/src
javac com/oceanview/resort/*.java
```

### Run
```bash
java com.oceanview.resort.HotelReservationSystem
```

### Or use the compile script
```bash
cd OceanViewResort
chmod +x compile.sh
./compile.sh
```

## Sample Usage

### 1. Login
```
Username: admin
Password: admin123
✓ Login successful! Welcome, admin!
```

### 2. Add Reservation
```
Reservation Number: RES-1001
--- Guest Information ---
Guest Name: John Smith
Address: 123 Beach Road, Colombo
Contact Number: +94 77 123 4567
Email: john@email.com

--- Room Selection ---
1. Standard Room - $75.00/night
2. Deluxe Room - $120.00/night
3. Suite - $250.00/night
Select room type (1-3): 2

Check-in Date (YYYY-MM-DD): 2024-03-15
Check-out Date (YYYY-MM-DD): 2024-03-18

✓ Reservation created successfully!
```

### 3. Display Reservation
```
Enter Reservation Number: RES-1001

╔════════════════════════════════════════════════════════════╗
║                 RESERVATION DETAILS                        ║
╠════════════════════════════════════════════════════════════╣
║ Reservation Number: RES-1001                               ║
║ Status: ACTIVE                                             ║
╠════════════════════════════════════════════════════════════╣
║ GUEST INFORMATION                                          ║
║ Name: John Smith                                           ║
║ Address: 123 Beach Road, Colombo                           ║
║ Contact: +94 77 123 4567                                   ║
╠════════════════════════════════════════════════════════════╣
║ ROOM INFORMATION                                           ║
║ Room Type: Deluxe Room                                     ║
║ Room Number: 201                                           ║
║ Rate per Night: $120.00                                    ║
╠════════════════════════════════════════════════════════════╣
║ STAY DETAILS                                               ║
║ Check-in Date:  2024-03-15                                 ║
║ Check-out Date: 2024-03-18                                 ║
║ Number of Nights: 3                                        ║
║ Total Amount: $360.00                                      ║
╚════════════════════════════════════════════════════════════╝
```

### 4. Generate Bill
```
Bill Number: BILL-1001

============================================================
                    OCEAN VIEW RESORT
                  Galle, Sri Lanka
                 Tel: +94 91 123 4567
============================================================
                      OFFICIAL BILL
============================================================
Bill Number: BILL-1001       Date: 2024-03-01 10:30:45
------------------------------------------------------------
GUEST DETAILS:
  Name: John Smith
  Address: 123 Beach Road, Colombo
  Contact: +94 77 123 4567
------------------------------------------------------------
RESERVATION DETAILS:
  Reservation #: RES-1001
  Room Type: Deluxe Room (Room 201)
  Check-in:  2024-03-15
  Check-out: 2024-03-18
  Nights: 3
------------------------------------------------------------
PAYMENT SUMMARY:
  Room Charges:       $    360.00
  Subtotal:           $    360.00
  Tax (15%):          $     54.00
------------------------------------------------------------
  GRAND TOTAL:        $    414.00
============================================================
    Thank you for choosing Ocean View Resort!
         We hope to see you again soon!
============================================================
```

## Technical Details

### Requirements
- Java 8 or higher
- Console/Terminal support

### Data Storage
- In-memory storage using HashMap
- Data persists during session only
- Can be extended to use database

### Date Handling
- Uses Java 8 java.time API
- Format: YYYY-MM-DD
- Automatic validation

## Future Enhancements

1. Database integration (MySQL/PostgreSQL)
2. Graphical User Interface (JavaFX/Swing)
3. Online booking portal
4. Email notifications
5. Payment gateway integration
6. Reporting and analytics
7. Multi-language support

## Author

**Ocean View Resort IT Department**  
Galle, Sri Lanka

## License

This project is proprietary software for Ocean View Resort internal use.
