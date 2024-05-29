package com.example.currencyservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Random;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class CurrencyController {

    @GetMapping("/currencies")
    public Currency getCurrency() {
        Random random = new Random();
        int number = random.nextInt(10) + 1;

        if (number <= 4) {
            throw new RuntimeException("Возникла ошибка в сервисе");
        }
        log.info("Запрос курса валют");
        return new Currency(BigDecimal.valueOf(12.86), BigDecimal.valueOf(98.5),
                BigDecimal.valueOf(102.3));
    }
}
