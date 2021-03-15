package com.demo.billingsystem.listener;

import com.demo.billingsystem.dto.CustomerAddressUpdateDto;
import com.demo.billingsystem.service.ReceiptService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressUpdateListener{

  @Autowired
  private ReceiptService receiptService;
  @Autowired
  private ObjectMapper objectMapper;

  @KafkaListener(topics = "integration.patterns.customer.address.update")
  public void consume(ConsumerRecord<String, String> record) throws JsonProcessingException {
    CustomerAddressUpdateDto dto = objectMapper.readValue(record.value(),
        new TypeReference<CustomerAddressUpdateDto>() {});
    receiptService.updateReceiptAddress(dto);
  }
}
