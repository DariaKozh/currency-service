package com.example.currencyservice;

import com.example.currencyservice.dto.DeleteOrderDto;
import com.example.currencyservice.dto.OrderDto;
import com.example.currencyservice.dto.UpdateOrderDto;
import com.example.currencyservice.dto.UpdateOrderStatusDto;
import com.example.currencyservice.kafka.Producer;
import com.example.currencyservice.kafka.events.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.currencyservice.kafka.Producer.TEST_TOPIC;

@RestController
@RequestMapping("/send")
@RequiredArgsConstructor
@Slf4j
public class KafkaController {

    private final Producer producer;

    @PostMapping("/currency")
    @ResponseStatus(HttpStatus.OK)
    public Currency sendCurrency(@RequestBody Currency currency) throws JsonProcessingException {
        log.info("Send currency to kafka");
        ModelMapper modelMapper = new ModelMapper();
        producer.sendEventString(TEST_TOPIC, "currency1", modelMapper.map(currency, CurrencySendEvent.class));

        return currency;
    }

    @PostMapping("/currency2")
    @ResponseStatus(HttpStatus.OK)
    public Currency sendCurrency2(@RequestBody Currency currency) throws JsonProcessingException {
        log.info("Send currency to kafka");
        ModelMapper modelMapper = new ModelMapper();
        producer.sendEventString(TEST_TOPIC, "currency2", modelMapper.map(currency, CurrencySendEvent.class));

        return currency;
    }

    @PostMapping("/currency3")
    @ResponseStatus(HttpStatus.OK)
    public Currency sendCurrency3(@RequestBody Currency currency) throws JsonProcessingException {
        log.info("Send currency to kafka");
        ModelMapper modelMapper = new ModelMapper();
        producer.sendEventByteArray(TEST_TOPIC, "currency1", modelMapper.map(currency, CurrencySendEvent.class));

        return currency;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto sendCreateOrder(@RequestBody OrderDto orderDto) throws JsonProcessingException {
        log.info("Send create order to kafka");
        ModelMapper modelMapper = new ModelMapper();
        producer.sendEventByteArray(TEST_TOPIC, "create", modelMapper.map(orderDto, OrderDtoSendEvent.class));

        return orderDto;
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdateOrderDto sendCreateOrder(@RequestBody UpdateOrderDto updateOrderDto) throws JsonProcessingException {
        log.info("Send update order to kafka");
        ModelMapper modelMapper = new ModelMapper();
        producer.sendEventByteArray(TEST_TOPIC, "update", modelMapper.map(updateOrderDto, UpdateOrderSendEvent.class));

        return updateOrderDto;
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public DeleteOrderDto sendDeleteOrder(@RequestBody DeleteOrderDto deleteOrderDto) throws JsonProcessingException {
        log.info("Send delete order to kafka");
        ModelMapper modelMapper = new ModelMapper();
        producer.sendEventByteArray(TEST_TOPIC, "delete", modelMapper.map(deleteOrderDto, DeleteOrderSendEvent.class));

        return deleteOrderDto;
    }

    @PostMapping("/status")
    @ResponseStatus(HttpStatus.OK)
    public UpdateOrderStatusDto sendUpdateStatusOrder(@RequestBody UpdateOrderStatusDto updateOrderStatusDto) throws JsonProcessingException {
        log.info("Send update order status to kafka");
        ModelMapper modelMapper = new ModelMapper();
        producer.sendEventByteArray(TEST_TOPIC, "delete", modelMapper.map(updateOrderStatusDto, UpdateOrderStatusSendEvent.class));

        return updateOrderStatusDto;
    }

    @PostMapping("/send-json")
    public ResponseEntity<String> sendJson(@RequestBody String json) throws JsonProcessingException {
        producer.sendEventByteArray(TEST_TOPIC, "currency1", json);
        return ResponseEntity.ok("JSON отправлен в тему");
    }
}
