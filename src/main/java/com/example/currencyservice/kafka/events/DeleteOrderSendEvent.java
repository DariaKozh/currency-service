package com.example.currencyservice.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteOrderSendEvent {
    private String event;
    private Long customerId;
    private UUID orderId;
}
