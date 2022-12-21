package com.tibame.tga104.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantRequest {
    @NotNull
    private Boolean restaurantStatus;
}
