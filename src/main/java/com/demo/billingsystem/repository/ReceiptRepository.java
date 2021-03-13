package com.demo.billingsystem.repository;

import com.demo.billingsystem.entity.Receipt;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReceiptRepository extends MongoRepository<Receipt, String> {

  List<Receipt> findAllByCustomerName(String customerName);
}
