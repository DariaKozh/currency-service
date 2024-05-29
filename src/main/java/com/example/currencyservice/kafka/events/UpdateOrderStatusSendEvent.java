package com.example.currencyservice.kafka.events;

import com.example.currencyservice.dto.ProductOrderDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderStatusSendEvent {
    private String event;
    private UUID orderId;
    private String status;
}
