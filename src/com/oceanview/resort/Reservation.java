package com.oceanview.resort;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Reservation class demonstrating AGGREGATION
 * Contains Guest and Room objects
 */
public class Reservation {
    private String reservationNumber;
    private Guest guest;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean isActive;
    private double totalAmount;
    
    public Reservation(String reservationNumber, Guest guest, Room room, 
                       LocalDate checkInDate, LocalDate checkOutDate) {
        this.reservationNumber = reservationNumber;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isActive = true;
        this.totalAmount = calculateTotalAmount();
    }
    
    // Calculate number of nights
    public long getNumberOfNights() {
        return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }
    
    // Calculate total amount based on nights and room rate
    private double calculateTotalAmount() {
        return getNumberOfNights() * room.getRatePerNight();
    }
    
    public void recalculateTotal() {
        this.totalAmount = calculateTotalAmount();
    }
    
    // Getters and Setters
    public String getReservationNumber() {
        return reservationNumber;
    }
    
    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
    
    public Guest getGuest() {
        return guest;
    }
    
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    
    public Room getRoom() {
        return room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
        recalculateTotal();
    }
    
    public LocalDate getCheckInDate() {
        return checkInDate;
    }
    
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
        recalculateTotal();
    }
    
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }
    
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
        recalculateTotal();
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean active) {
        isActive = active;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    @Override
    public String toString() {
        return String.format(
            "╔════════════════════════════════════════════════════════════╗\n" +
            "║                 RESERVATION DETAILS                        ║\n" +
            "╠════════════════════════════════════════════════════════════╣\n" +
            "║ Reservation Number: %-40s ║\n" +
            "║ Status: %-50s ║\n" +
            "╠════════════════════════════════════════════════════════════╣\n" +
            "║ GUEST INFORMATION                                          ║\n" +
            "║ Name: %-52s ║\n" +
            "║ Address: %-49s ║\n" +
            "║ Contact: %-49s ║\n" +
            "╠════════════════════════════════════════════════════════════╣\n" +
            "║ ROOM INFORMATION                                           ║\n" +
            "║ Room Type: %-47s ║\n" +
            "║ Room Number: %-45s ║\n" +
            "║ Rate per Night: $%-42.2f ║\n" +
            "║ Amenities: %-47s ║\n" +
            "╠════════════════════════════════════════════════════════════╣\n" +
            "║ STAY DETAILS                                               ║\n" +
            "║ Check-in Date:  %-43s ║\n" +
            "║ Check-out Date: %-43s ║\n" +
            "║ Number of Nights: %-41d ║\n" +
            "║ Total Amount: $%-45.2f ║\n" +
            "╚════════════════════════════════════════════════════════════╝",
            reservationNumber,
            isActive ? "ACTIVE" : "CANCELLED",
            guest.getName(),
            guest.getAddress(),
            guest.getContactNumber(),
            room.getRoomType(),
            room.getRoomNumber(),
            room.getRatePerNight(),
            room.getAmenities(),
            checkInDate.toString(),
            checkOutDate.toString(),
            getNumberOfNights(),
            totalAmount
        );
    }
}
