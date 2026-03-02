package com.oceanview.resort;

import java.util.HashMap;
import java.util.Map;

/**
 * Authentication class for USER AUTHENTICATION
 * Manages user credentials and login functionality
 */
public class Authentication {
    private Map<String, String> users;
    private String currentUser;
    private boolean isLoggedIn;
    private int loginAttempts;
    private static final int MAX_ATTEMPTS = 3;
    
    public Authentication() {
        this.users = new HashMap<>();
        this.currentUser = null;
        this.isLoggedIn = false;
        this.loginAttempts = 0;
        
        // Initialize default users
        initializeDefaultUsers();
    }
    
    private void initializeDefaultUsers() {
        // Default staff accounts
        users.put("admin", "admin123");
        users.put("manager", "manager123");
        users.put("receptionist", "reception123");
        users.put("staff", "staff123");
    }
    
    /**
     * Authenticate user with username and password
     * @param username The username
     * @param password The password
     * @return true if authentication successful, false otherwise
     */
    public boolean login(String username, String password) {
        if (loginAttempts >= MAX_ATTEMPTS) {
            System.out.println("Account locked! Too many failed attempts.");
            return false;
        }
        
        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            isLoggedIn = true;
            loginAttempts = 0;
            System.out.println("\n✓ Login successful! Welcome, " + username + "!");
            return true;
        } else {
            loginAttempts++;
            int remaining = MAX_ATTEMPTS - loginAttempts;
            System.out.println("✗ Invalid username or password!");
            System.out.println("  Attempts remaining: " + remaining);
            return false;
        }
    }
    
    /**
     * Logout current user
     */
    public void logout() {
        if (isLoggedIn) {
            System.out.println("\nGoodbye, " + currentUser + "!");
            currentUser = null;
            isLoggedIn = false;
        }
    }
    
    /**
     * Add new user (for admin)
     * @param username New username
     * @param password New password
     * @return true if added successfully
     */
    public boolean addUser(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return false;
        }
        users.put(username, password);
        return true;
    }
    
    /**
     * Change password
     * @param username Username
     * @param oldPassword Current password
     * @param newPassword New password
     * @return true if changed successfully
     */
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        if (!users.containsKey(username) || !users.get(username).equals(oldPassword)) {
            System.out.println("Invalid username or password!");
            return false;
        }
        users.put(username, newPassword);
        System.out.println("Password changed successfully!");
        return true;
    }
    
    // Getters
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    
    public String getCurrentUser() {
        return currentUser;
    }
    
    public int getRemainingAttempts() {
        return MAX_ATTEMPTS - loginAttempts;
    }
}
