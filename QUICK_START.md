# Quick Start Guide - Ocean View Resort Reservation System

## 🚀 Getting Started in 3 Steps

### Step 1: Compile the Application

**On Linux/Mac:**
```bash
cd OceanViewResort
chmod +x compile.sh
./compile.sh
```

**On Windows:**
```cmd
cd OceanViewResort
compile.bat
```

Or manually:
```bash
cd OceanViewResort/src
javac com/oceanview/resort/*.java
```

### Step 2: Run the Application

**On Linux/Mac:**
```bash
./run.sh
```

**On Windows:**
```cmd
run.bat
```

Or manually:
```bash
cd OceanViewResort/src
java com.oceanview.resort.HotelReservationSystem
```

### Step 3: Login and Start Using

**Default Credentials:**
- Username: `admin`
- Password: `admin123`

---

## 📋 Menu Options

```
┌─────────────────────────────────────────────────────────────┐
│                    MAIN MENU                                │
├─────────────────────────────────────────────────────────────┤
│  1. User Authentication (Login)                             │
│  2. Add New Reservation                                     │
│  3. Display Reservation Details                             │
│  4. Calculate and Print Bill                                │
│  5. Help Section                                            │
│  6. Exit System                                             │
└─────────────────────────────────────────────────────────────┘
```

---

## 📝 Sample Workflow

### 1. Login
```
Username: admin
Password: admin123
✓ Login successful! Welcome, admin!
```

### 2. Add a Reservation
```
Select: 2

Guest Name: John Smith
Address: 123 Beach Road, Colombo
Contact Number: +94 77 123 4567
Email: john@email.com

Room Selection:
1. Standard Room - $75.00/night
2. Deluxe Room - $120.00/night
3. Suite - $250.00/night
Select: 2

Check-in Date: 2024-03-15
Check-out Date: 2024-03-18

✓ Reservation created: RES-1001
```

### 3. View Reservation
```
Select: 3
Enter Reservation Number: RES-1001

[Complete reservation details displayed]
```

### 4. Generate Bill
```
Select: 4
Enter Reservation Number: RES-1001

Add service charges? (y/n): n
Apply discount? (y/n): n
Print detailed? (y/n): y

[Professional bill displayed]
```

### 5. Logout and Exit
```
Select: 6
Are you sure? (y/n): y

Goodbye, admin!
Thank you for using Ocean View Resort!
```

---

## 💡 Tips

1. **Always login first** before using reservation features
2. **Date format:** Use `YYYY-MM-DD` (e.g., 2024-03-15)
3. **Room availability:** System auto-assigns available rooms
4. **Help anytime:** Press `5` for detailed help on any feature
5. **Default users:** admin, manager, receptionist, staff

---

## 🔧 Troubleshooting

| Problem | Solution |
|---------|----------|
| "javac not found" | Install JDK from oracle.com/java |
| "Class not found" | Compile first using compile.sh/bat |
| "Login failed" | Check username/password (case-sensitive) |
| "Invalid date" | Use format: YYYY-MM-DD |
| "No rooms available" | All rooms of that type are booked |

---

## 📊 Room Rates Summary

| Room Type | Rate/Night | Total for 3 Nights |
|-----------|------------|-------------------|
| Standard | $75.00 | $225.00 + tax |
| Deluxe | $120.00 | $360.00 + tax |
| Suite | $250.00 | $750.00 + tax |

*Tax: 15% on subtotal*

---

## 🎓 Learning OOP with This System

This project demonstrates:
- **Encapsulation** → Guest class (private fields)
- **Inheritance** → Room → StandardRoom/DeluxeRoom/Suite
- **Polymorphism** → Different rates per room type
- **Abstraction** → Abstract Room class
- **Aggregation** → Reservation has Guest and Room

View `UML_DIAGRAM.md` for complete class diagram!

---

**Happy Managing! 🏨**
*Ocean View Resort - Galle, Sri Lanka*
