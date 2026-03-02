package com.oceanview.resort;

/**
 * Suite class demonstrating INHERITANCE
 * Extends abstract Room class with premium rate
 */
public class Suite extends Room {
    private static final double RATE_PER_NIGHT = 250.00;
    private static final String TYPE = "Presidential Suite";
    
    public Suite(String roomNumber) {
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
        return "Master Bedroom, Living Room, Ocean View, 2 Smart TVs, Jacuzzi, " +
               "Kitchenette, Butler Service, Private Terrace";
    }
}
