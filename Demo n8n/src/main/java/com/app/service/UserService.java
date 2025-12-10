package com.app.service;

/**
 * Handles basic user-related business logic.
 */
public class UserService {

    // Existing method
    public String getUsernameById(long userId) {
        if (userId == 101) {
            return "TestUser";
        }
        return "Unknown";
    }

    // Placeholder for the new method logic
    public boolean isActive(long userId) {
        // Will be implemented in the PR
        return false;
    }
}
