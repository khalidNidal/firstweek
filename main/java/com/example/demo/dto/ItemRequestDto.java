package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemRequestDto {

    @NotBlank(message = "itemName is required")
    private String itemName;

    @PositiveOrZero(message = "quantity must be >= 0")
    private int quantity;

    @Positive(message = "price must be > 0")
    private double price;
}
