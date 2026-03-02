package com.oceanview.resort;

/**
 * DeluxeRoom class demonstrating INHERITANCE
 * Extends abstract Room class with higher rate
 */
public class DeluxeRoom extends Room {
    private static final double RATE_PER_NIGHT = 120.00;
    private static final String TYPE = "Deluxe Room";
    
    public DeluxeRoom(String roomNumber) {
        super(roomNumber);
    }
    
    @Override
    public double getRatePerNight() {
        return RATE_PER_NIGHT;
    }
    
    @Override
    public String getRoomType() {
        return TYPE;
    }
    
    @Override
    public String getAmenities() {
        return "King Bed, Ocean View, Smart TV, AC, WiFi, Mini Bar, Balcony";
    }
}
