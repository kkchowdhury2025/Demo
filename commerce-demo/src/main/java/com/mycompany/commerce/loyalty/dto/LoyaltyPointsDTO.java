package com.mycompany.commerce.loyalty.dto;

public class LoyaltyPointsDTO {
    private String userId;
    private int totalPoints;

    public LoyaltyPointsDTO(String userId, int totalPoints) {
        this.userId = userId;
        this.totalPoints = totalPoints;
    }

    public String getUserId() {
        return userId;
    }

    public int getTotalPoints() {
        return totalPoints;
    }
}
