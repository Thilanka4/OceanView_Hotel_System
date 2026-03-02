package com.oceanview.resort;

/**
 * Abstract Room class demonstrating ABSTRACTION
 * Serves as base class for all room types
 */
public abstract class Room {
    private String roomNumber;
    private boolean isAvailable;
    
    public Room(String roomNumber) {
        this.roomNumber = roomNumber;
        this.isAvailable = true;
    }
    
    // Abstract method - must be implemented by subclasses (POLYMORPHISM)
    public abstract double getRatePerNight();
    
    public abstract String getRoomType();
    
    public abstract String getAmenities();
    
    // Concrete methods
    public String getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    
    @Override
    public String toString() {
        return String.format("Room %s (%s) - Rate: $%.2f/night", 
            roomNumber, getRoomType(), getRatePerNight());
    }
}
