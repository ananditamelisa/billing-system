package com.demo.billingsystem.controller;

import com.demo.billingsystem.entity.Receipt;
import com.demo.billingsystem.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceiptController {

  @Autowired
  private ReceiptService receiptService;

  @GetMapping(value = {"/receipt/customer-name"},
      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
  public List<Receipt> getReceiptsByCustomerName(@RequestParam String customerName) {
    return receiptService.getReceiptsByCustomerName(customerName);
  }
}
