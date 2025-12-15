package com.mycompany.commerce.loyalty.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mycompany.commerce.exception.UserNotFoundException;
import com.mycompany.commerce.loyalty.dto.LoyaltyPointsDTO;
import com.mycompany.commerce.loyalty.service.LoyaltyService;

@ExtendWith(MockitoExtension.class)
class LoyaltyResourceTest {

    @Mock
    private LoyaltyService loyaltyService;

    @InjectMocks
    private LoyaltyResource loyaltyResource;

    @Test
    void success() throws Exception {
        when(loyaltyService.getUserPoints("1","u")).thenReturn(new LoyaltyPointsDTO("u",100));
        Response r = loyaltyResource.getPoints("1","u");
        assertEquals(200, r.getStatus());
    }

    @Test
    void notFound() throws Exception {
        when(loyaltyService.getUserPoints(anyString(),anyString()))
            .thenThrow(new UserNotFoundException("x"));
        Response r = loyaltyResource.getPoints("1","u");
        assertEquals(404, r.getStatus());
    }

    @Test
    void serverError() throws Exception {
        when(loyaltyService.getUserPoints(anyString(),anyString()))
            .thenThrow(new RuntimeException());
        Response r = loyaltyResource.getPoints("1","u");
        assertEquals(500, r.getStatus());
    }
}
