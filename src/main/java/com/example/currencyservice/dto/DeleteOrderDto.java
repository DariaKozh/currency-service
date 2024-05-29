package com.example.currencyservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DeleteOrderDto {
    private String event;
    private Long customerId;
    private UUID orderId;
}
