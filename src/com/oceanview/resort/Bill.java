package com.oceanview.resort;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Bill class demonstrating POLYMORPHISM
 * Can generate different types of bills
 */
public class Bill {
    private String billNumber;
    private Reservation reservation;
    private LocalDateTime billDate;
    private double serviceCharges;
    private double taxRate;
    private double discount;
    
    private static int billCounter = 1000;
    private static final double DEFAULT_TAX_RATE = 0.15; // 15% tax
    
    public Bill(Reservation reservation) {
        this.billNumber = "BILL-" + (++billCounter);
        this.reservation = reservation;
        this.billDate = LocalDateTime.now();
        this.serviceCharges = 0.0;
        this.taxRate = DEFAULT_TAX_RATE;
        this.discount = 0.0;
    }
    
    // Constructor with service charges - POLYMORPHISM (Constructor overloading)
    public Bill(Reservation reservation, double serviceCharges) {
        this(reservation);
        this.serviceCharges = serviceCharges;
    }
    
    // Calculate subtotal
    public double getSubtotal() {
        return reservation.getTotalAmount() + serviceCharges - discount;
    }
    
    // Calculate tax amount
    public double getTaxAmount() {
        return getSubtotal() * taxRate;
    }
    
    // Calculate grand total
    public double getGrandTotal() {
        return getSubtotal() + getTaxAmount();
    }
    
    // Print bill - POLYMORPHISM (Method overloading)
    public void printBill() {
        printBill(false);
    }
    
    public void printBill(boolean detailed) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    OCEAN VIEW RESORT");
        System.out.println("                  Galle, Sri Lanka");
        System.out.println("                 Tel: +94 91 123 4567");
        System.out.println("=".repeat(60));
        System.out.println("                      OFFICIAL BILL");
        System.out.println("=".repeat(60));
        System.out.printf("Bill Number: %-20s Date: %s%n", 
            billNumber, billDate.format(formatter));
        System.out.println("-".repeat(60));
        System.out.println("GUEST DETAILS:");
        System.out.printf("  Name: %s%n", reservation.getGuest().getName());
        System.out.printf("  Address: %s%n", reservation.getGuest().getAddress());
        System.out.printf("  Contact: %s%n", reservation.getGuest().getContactNumber());
        System.out.println("-".repeat(60));
        System.out.println("RESERVATION DETAILS:");
        System.out.printf("  Reservation #: %s%n", reservation.getReservationNumber());
        System.out.printf("  Room Type: %s (Room %s)%n", 
            reservation.getRoom().getRoomType(),
            reservation.getRoom().getRoomNumber());
        System.out.printf("  Check-in:  %s%n", reservation.getCheckInDate());
        System.out.printf("  Check-out: %s%n", reservation.getCheckOutDate());
        System.out.printf("  Nights: %d%n", reservation.getNumberOfNights());
        System.out.println("-".repeat(60));
        
        if (detailed) {
            System.out.println("CHARGE BREAKDOWN:");
            System.out.printf("  Room Rate:          $%10.2f x %d nights%n", 
                reservation.getRoom().getRatePerNight(), 
                reservation.getNumberOfNights());
        }
        
        System.out.println("PAYMENT SUMMARY:");
        System.out.printf("  Room Charges:       $%10.2f%n", reservation.getTotalAmount());
        if (serviceCharges > 0) {
            System.out.printf("  Service Charges:    $%10.2f%n", serviceCharges);
        }
        if (discount > 0) {
            System.out.printf("  Discount:          -$%10.2f%n", discount);
        }
        System.out.printf("  Subtotal:           $%10.2f%n", getSubtotal());
        System.out.printf("  Tax (%.0f%%):          $%10.2f%n", 
            taxRate * 100, getTaxAmount());
        System.out.println("-".repeat(60));
        System.out.printf("  GRAND TOTAL:        $%10.2f%n", getGrandTotal());
        System.out.println("=".repeat(60));
        System.out.println("    Thank you for choosing Ocean View Resort!");
        System.out.println("         We hope to see you again soon!");
        System.out.println("=".repeat(60));
    }
    
    // Getters and Setters
    public String getBillNumber() {
        return billNumber;
    }
    
    public Reservation getReservation() {
        return reservation;
    }
    
    public double getServiceCharges() {
        return serviceCharges;
    }
    
    public void setServiceCharges(double serviceCharges) {
        this.serviceCharges = serviceCharges;
    }
    
    public double getDiscount() {
        return discount;
    }
    
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }
}
