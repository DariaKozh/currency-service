package com.example.currencyservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UpdateOrderStatusDto {
    private String event;
    private UUID orderId;
    private String status;
}
