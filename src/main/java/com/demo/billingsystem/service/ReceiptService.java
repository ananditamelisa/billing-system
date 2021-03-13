package com.demo.billingsystem.service;

import com.demo.billingsystem.dto.CustomerAddressUpdateDto;
import com.demo.billingsystem.entity.Receipt;

import java.util.List;

public interface ReceiptService {

  void updateReceiptAddress(CustomerAddressUpdateDto customerAddressUpdateDto);

  List<Receipt> getReceiptsByCustomerName(String customerName);
}
