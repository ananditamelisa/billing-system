package com.demo.billingsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = Receipt.COLLECTION_NAME)
public class Receipt {

  public static final String COLLECTION_NAME = "RECEIPT";

  @Id
  private String id;
  private String customerName;
  private String customerAddress;
  private int totalPayment;
  private Date createdDate;
}
