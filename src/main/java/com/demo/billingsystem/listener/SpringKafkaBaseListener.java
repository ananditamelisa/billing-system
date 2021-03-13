package com.demo.billingsystem.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.function.Consumer;

@Slf4j
public abstract class SpringKafkaBaseListener {

  @Autowired
  private ObjectMapper objectMapper;

  public abstract void onDomainEventConsumed(ConsumerRecord<String, String> record);

  protected <T> void processConsumerRecord(ConsumerRecord<String, String> record,
      Consumer<? super T> consumer, TypeReference<T> typeReference) {
    log.warn("Spring kafka listener consume from topic {} with record value {}", record.topic(), record.value());
    Optional<T> optionalValue;
    try {
      optionalValue = Optional.of(objectMapper.readValue(record.value(), typeReference));
    } catch (JsonProcessingException e) {
      optionalValue = Optional.empty();
    }
    if (optionalValue.isPresent()) {
      consumer.accept(optionalValue.get());
      log.warn("Spring kafka listener consume from topic {} success processing record value", record.topic());
    } else {
      log.error("Spring kafka listener consume from topic {} failed to read record value", record.topic());
    }
  }
}
