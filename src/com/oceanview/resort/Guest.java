package com.oceanview.resort;

/**
 * Guest class demonstrating ENCAPSULATION
 * All fields are private with public getters/setters
 */
public class Guest {
    private String guestId;
    private String name;
    private String address;
    private String contactNumber;
    private String email;
    
    // Default constructor
    public Guest() {
    }
    
    // Parameterized constructor
    public Guest(String guestId, String name, String address, String contactNumber, String email) {
        this.guestId = guestId;
        this.name = name;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
    }
    
    // Getters and Setters - ENCAPSULATION
    public String getGuestId() {
        return guestId;
    }
    
    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getContactNumber() {
        return contactNumber;
    }
    
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return String.format(
            "Guest ID: %s\n" +
            "Name: %s\n" +
            "Address: %s\n" +
            "Contact: %s\n" +
            "Email: %s",
            guestId, name, address, contactNumber, email
        );
    }
}
