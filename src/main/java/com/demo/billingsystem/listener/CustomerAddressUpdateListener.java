package com.demo.billingsystem.listener;

import com.demo.billingsystem.dto.CustomerAddressUpdateDto;
import com.demo.billingsystem.service.ReceiptService;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CustomerAddressUpdateListener extends SpringKafkaBaseListener{

  @Autowired
  private ReceiptService receiptService;

  @Override
  @KafkaListener(topics = "integration.patterns.customer.address.update")
  public void onDomainEventConsumed(ConsumerRecord<String, String> record) {
    super.processConsumerRecord(record,
        receiptService::updateReceiptAddress,
        new TypeReference<CustomerAddressUpdateDto>() {});
  }
}
