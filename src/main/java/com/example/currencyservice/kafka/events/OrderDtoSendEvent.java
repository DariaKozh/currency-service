package com.example.currencyservice.kafka.events;

import com.example.currencyservice.dto.ProductOrderDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoSendEvent {
    private String event;
    private Long customerId;
    private String deliveryAddress;
    private List<ProductOrderDto> products;
}
