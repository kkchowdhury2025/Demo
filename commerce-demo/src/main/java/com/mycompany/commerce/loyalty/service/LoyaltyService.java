package com.mycompany.commerce.loyalty.service;

import com.mycompany.commerce.exception.UserNotFoundException;
import com.mycompany.commerce.loyalty.dto.LoyaltyPointsDTO;

public interface LoyaltyService {
    LoyaltyPointsDTO getUserPoints(String storeId, String userId) throws UserNotFoundException;
}
