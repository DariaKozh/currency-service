package com.example.currencyservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UpdateOrderDto {
    private String event;
    private Long customerId;
    private UUID orderId;
    private List<ProductOrderDto> products;
}
