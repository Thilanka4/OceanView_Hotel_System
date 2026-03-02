package com.oceanview.resort;

/**
 * StandardRoom class demonstrating INHERITANCE
 * Extends abstract Room class
 */
public class StandardRoom extends Room {
    private static final double RATE_PER_NIGHT = 75.00;
    private static final String TYPE = "Standard Room";
    
    public StandardRoom(String roomNumber) {
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
        return "Single/Double Bed, TV, AC, WiFi, Mini Fridge";
    }
}
