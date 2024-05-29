package com.example.currencyservice;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Currency {
    private BigDecimal exchangeRateCNY;
    private BigDecimal exchangeRateUSD;
    private BigDecimal exchangeRateEUR;
}
