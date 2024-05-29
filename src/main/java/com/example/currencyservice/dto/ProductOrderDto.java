package com.example.currencyservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ProductOrderDto {
    private UUID id;
    private Integer quantity;
}
