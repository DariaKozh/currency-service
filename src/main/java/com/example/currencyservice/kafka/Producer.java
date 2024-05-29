package com.example.currencyservice.kafka;

import com.example.currencyservice.kafka.events.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "app", name = "kafka.enabled", matchIfMissing = false)
public class Producer {
    private final KafkaTemplate<String, String> kafkaTemplateString;
    private final KafkaTemplate<String, byte[]> kafkaTemplateByteArray;

    public static final String TEST_TOPIC = "test_topic";

    public void sendEventString(final String topic, final String key, final CurrencySendEvent event) throws JsonProcessingException {

        final ObjectMapper objectMapper = new ObjectMapper();
        final String data = objectMapper.writeValueAsString(event);

        kafkaTemplateString.send(topic, key, data);
    }

    public void sendEventByteArray(final String topic, final String key, final CurrencySendEvent event) throws JsonProcessingException {

        final ObjectMapper objectMapper = new ObjectMapper();
        final byte[] data = objectMapper.writeValueAsBytes(event); // Serialize to byte[]

        kafkaTemplateByteArray.send(topic, key, data);
    }

    public void sendEventByteArray(final String topic, final String key, final OrderDtoSendEvent event) throws JsonProcessingException {

        final ObjectMapper objectMapper = new ObjectMapper();
        final byte[] data = objectMapper.writeValueAsBytes(event); // Serialize to byte[]

        kafkaTemplateByteArray.send(topic, key, data);
    }

    public void sendEventByteArray(final String topic, final String key, final UpdateOrderSendEvent event) throws JsonProcessingException {

        final ObjectMapper objectMapper = new ObjectMapper();
        final byte[] data = objectMapper.writeValueAsBytes(event); // Serialize to byte[]

        kafkaTemplateByteArray.send(topic, key, data);
    }

    public void sendEventByteArray(final String topic, final String key, final DeleteOrderSendEvent event) throws JsonProcessingException {

        final ObjectMapper objectMapper = new ObjectMapper();
        final byte[] data = objectMapper.writeValueAsBytes(event); // Serialize to byte[]

        kafkaTemplateByteArray.send(topic, key, data);
    }

    public void sendEventByteArray(final String topic, final String key, final UpdateOrderStatusSendEvent event) throws JsonProcessingException {

        final ObjectMapper objectMapper = new ObjectMapper();
        final byte[] data = objectMapper.writeValueAsBytes(event); // Serialize to byte[]

        kafkaTemplateByteArray.send(topic, key, data);
    }

    public void sendEventByteArray(final String topic, final String key, final String json) throws JsonProcessingException {

        final ObjectMapper objectMapper = new ObjectMapper();
        final byte[] data = objectMapper.writeValueAsBytes(json); // Serialize to byte[]

        kafkaTemplateByteArray.send(topic, key, data);
    }
}
