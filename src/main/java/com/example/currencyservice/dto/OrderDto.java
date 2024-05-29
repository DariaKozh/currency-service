package com.example.currencyservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderDto {
    private String event;
    private Long customerId;
    private String deliveryAddress;
    private List<ProductOrderDto> products;
}
