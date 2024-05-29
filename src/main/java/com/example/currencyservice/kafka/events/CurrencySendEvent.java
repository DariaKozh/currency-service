package com.example.currencyservice.kafka.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencySendEvent{
    private BigDecimal exchangeRateCNY;
    private BigDecimal exchangeRateUSD;
    private BigDecimal exchangeRateEUR;
}
