# UML Class Diagram - Ocean View Resort Reservation System

## Class Hierarchy

```
┌─────────────────────────────────────────────────────────────────────────────┐
│                           CLASS DIAGRAM                                      │
└─────────────────────────────────────────────────────────────────────────────┘

┌─────────────────────┐
│   <<abstract>>      │
│      Room           │◄─────────────────────────────────────┐
├─────────────────────┤                                      │
│ - roomNumber: String│                                      │
│ - isAvailable: boolean                                     │
├─────────────────────┤                                      │
│ + getRatePerNight() │                                      │
│   abstract double   │                                      │
│ + getRoomType()     │                                      │
│   abstract String   │                                      │
│ + getAmenities()    │                                      │
│   abstract String   │                                      │
│ + isAvailable()     │                                      │
│   boolean           │                                      │
│ + setAvailable()    │                                      │
│   void              │                                      │
└─────────────────────┘                                      │
         ▲                                                   │
         │ INHERITANCE                                       │
    ┌────┴────┬────────┬────────┐                            │
    │         │        │        │                            │
    ▼         ▼        ▼        ▼                            │
┌────────┐ ┌────────┐ ┌─────┐                              │
│Standard│ │Deluxe  │ │Suite│                              │
│ Room   │ │ Room   │ │     │                              │
├────────┤ ├────────┤ ├─────┤                              │
│$75/night│ │$120/  │ │$250/│                              │
│        │ │night   │ │night│                              │
└────────┘ └────────┘ └─────┘                              │
                                                           │
                                                           │
┌─────────────────────┐                                    │
│      Guest          │                                    │
├─────────────────────┤                                    │
│ - guestId: String   │                                    │
│ - name: String      │                                    │
│ - address: String   │                                    │
│ - contactNumber:    │                                    │
│   String            │                                    │
│ - email: String     │                                    │
├─────────────────────┤                                    │
│ + getName() String  │                                    │
│ + setName() void    │                                    │
│ + getAddress()      │                                    │
│   String            │                                    │
│ + setAddress() void │                                    │
│ + getContactNumber()│                                    │
│   String            │                                    │
│ + setContactNumber()│                                    │
│   void              │                                    │
└─────────────────────┘                                    │
         ▲                                                 │
         │                                                 │
         │ AGGREGATION                                     │
         │                                                 │
         ▼                                                 │
┌─────────────────────┐         AGGREGATION                │
│    Reservation      │◄───────────────────────────────────┘
├─────────────────────┤
│ - reservationNumber:│
│   String            │
│ - guest: Guest      │
│ - room: Room        │
│ - checkInDate:      │
│   LocalDate         │
│ - checkOutDate:     │
│   LocalDate         │
│ - isActive: boolean │
│ - totalAmount:      │
│   double            │
├─────────────────────┤
│ + getNumberOfNights()│
│   long              │
│ + calculateTotal()  │
│   double            │
│ + toString() String │
└─────────────────────┘
         ▲
         │
         │ ASSOCIATION
         │
         ▼
┌─────────────────────┐
│       Bill          │
├─────────────────────┤
│ - billNumber:       │
│   String            │
│ - reservation:      │
│   Reservation       │
│ - billDate:         │
│   LocalDateTime     │
│ - serviceCharges:   │
│   double            │
│ - taxRate: double   │
│ - discount: double  │
├─────────────────────┤
│ + getGrandTotal()   │
│   double            │
│ + getTaxAmount()    │
│   double            │
│ + printBill() void  │
│ + printBill(boolean)│
│   void              │
└─────────────────────┘

┌─────────────────────┐
│  Authentication     │
├─────────────────────┤
│ - users: Map        │
│ - currentUser:      │
│   String            │
│ - isLoggedIn:       │
│   boolean           │
│ - loginAttempts:    │
│   int               │
├─────────────────────┤
│ + login() boolean   │
│ + logout() void     │
│ + addUser() boolean │
│ + changePassword()  │
│   boolean           │
│ + isLoggedIn()      │
│   boolean           │
└─────────────────────┘

┌─────────────────────┐
│   HelpSection       │
├─────────────────────┤
│ + displayMainMenu() │
│   static void       │
│ + displayLoginHelp()│
│   static void       │
│ + displayAddReserva-│
│   tionHelp() void   │
│ + displayViewReser- │
│   vationHelp() void │
│ + displayBillHelp() │
│   static void       │
│ + displayOOPConcepts│
│   () static void    │
│ + displayAllHelp()  │
│   static void       │
└─────────────────────┘

┌─────────────────────────────────────────────────────────────┐
│              HotelReservationSystem                          │
│                    (Main Class)                              │
├─────────────────────────────────────────────────────────────┤
│ - auth: Authentication                                       │
│ - reservations: Map<String, Reservation>                     │
│ - rooms: Map<String, Room>                                   │
│ - scanner: Scanner                                           │
│ - reservationCounter: int                                    │
├─────────────────────────────────────────────────────────────┤
│ + start() void                                               │
│ - displayWelcomeScreen() void                                │
│ - displayMainMenu() void                                     │
│ - handleLogin() void                                         │
│ - handleAddReservation() void                                │
│ - handleDisplayReservation() void                            │
│ - handleCalculateBill() void                                 │
│ - handleExit() boolean                                       │
│ - checkAuth() boolean                                        │
│ - initializeRooms() void                                     │
│ + main(String[]) void                                        │
└─────────────────────────────────────────────────────────────┘
```

## Relationships Explained

### 1. INHERITANCE (IS-A Relationship)
```
Room (abstract parent)
    ↑
    ├── StandardRoom
    ├── DeluxeRoom
    └── Suite
```
- All room types inherit from abstract `Room` class
- Each subclass implements abstract methods with specific behavior
- Common attributes and methods defined in parent class

### 2. AGGREGATION (HAS-A Relationship)
```
Reservation ──► Guest
Reservation ──► Room
```
- `Reservation` contains references to `Guest` and `Room`
- Objects can exist independently
- Whole-part relationship where parts can be shared

### 3. ASSOCIATION (USES Relationship)
```
Bill ──► Reservation
Authentication ──► HotelReservationSystem
```
- Objects use each other but don't own each other
- `Bill` uses `Reservation` to calculate charges
- `HotelReservationSystem` uses `Authentication` for login

### 4. DEPENDENCY
```
HotelReservationSystem ──► HelpSection
```
- `HotelReservationSystem` depends on `HelpSection`
- Uses static methods for displaying help

## OOP Concepts Mapping

| Concept | Implementation | Classes Involved |
|---------|---------------|------------------|
| **Encapsulation** | Private fields with public getters/setters | Guest, Reservation, Bill, Authentication |
| **Inheritance** | Abstract Room class with concrete subclasses | Room → StandardRoom, DeluxeRoom, Suite |
| **Polymorphism** | Method overriding (getRatePerNight) and overloading (printBill) | Room hierarchy, Bill |
| **Abstraction** | Abstract Room class hiding implementation | Room |
| **Aggregation** | Reservation contains Guest and Room | Reservation, Guest, Room |

## Sequence Diagram - Add Reservation

```
User                    HRS                    Guest                    Room                    Reservation
 │                       │                       │                       │                       │
 │─── Add Reservation ──►│                       │                       │                       │
 │                       │─── create Guest() ───►│                       │                       │
 │                       │◄──── Guest obj ───────│                       │                       │
 │                       │                       │                       │                       │
 │                       │─── select Room() ─────────────────────────────►│                       │
 │                       │◄──── Room obj ────────────────────────────────│                       │
 │                       │                       │                       │                       │
 │                       │─── create Reservation(Guest, Room) ───────────────────────────────────►│
 │                       │◄──── Reservation obj ─────────────────────────────────────────────────│
 │                       │                       │                       │                       │
 │◄── Confirmation ──────│                       │                       │                       │
 │                       │                       │                       │                       │
```

## Class Statistics

| Class | Methods | Fields | Lines of Code | Responsibility |
|-------|---------|--------|---------------|----------------|
| Room (abstract) | 7 | 2 | ~50 | Base class for all rooms |
| StandardRoom | 3 | 2 | ~25 | Standard room implementation |
| DeluxeRoom | 3 | 2 | ~25 | Deluxe room implementation |
| Suite | 3 | 2 | ~25 | Suite implementation |
| Guest | 12 | 5 | ~80 | Guest data management |
| Reservation | 15 | 6 | ~120 | Booking management |
| Bill | 12 | 6 | ~100 | Billing and invoicing |
| Authentication | 7 | 5 | ~80 | Login and security |
| HelpSection | 8 | 0 | ~200 | User documentation |
| HotelReservationSystem | 12 | 5 | ~350 | Main application |

**Total: ~1055 lines of Java code**
