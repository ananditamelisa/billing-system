package com.demo.billingsystem.service;

import com.demo.billingsystem.dto.CustomerAddressUpdateDto;
import com.demo.billingsystem.entity.Receipt;
import com.demo.billingsystem.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService{

  @Autowired
  private ReceiptRepository receiptRepository;

  @Override
  public void updateReceiptAddress(CustomerAddressUpdateDto customerAddressUpdateDto) {
    List<Receipt> receiptList = receiptRepository.findAllByCustomerName(customerAddressUpdateDto.getName());
    receiptList.forEach(receipt -> {
      receipt.setCustomerAddress(customerAddressUpdateDto.getNewAddress());
    });
    receiptRepository.saveAll(receiptList);
  }

  @Override
  public List<Receipt> getReceiptsByCustomerName(String customerName) {
    return receiptRepository.findAllByCustomerName(customerName);
  }
}
