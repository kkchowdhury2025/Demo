package com.mycompany.commerce.loyalty.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mycompany.commerce.exception.UserNotFoundException;
import com.mycompany.commerce.loyalty.dto.LoyaltyPointsDTO;
import com.mycompany.commerce.loyalty.service.LoyaltyService;

@Path("/store/{storeId}/loyalty")
public class LoyaltyResource {

    private LoyaltyService loyaltyService;

    public LoyaltyResource(LoyaltyService loyaltyService) {
        this.loyaltyService = loyaltyService;
    }

    @GET
    @Path("/{userId}/points")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPoints(@PathParam("storeId") String storeId,
                              @PathParam("userId") String userId) {
        try {
            LoyaltyPointsDTO dto =
                    loyaltyService.getUserPoints(storeId, userId);
            return Response.ok(dto).build();
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("User ID not found: " + userId)
                    .build();
        } catch (Exception e) {
            return Response.serverError()
                    .entity("Internal error")
                    .build();
        }
    }
}
