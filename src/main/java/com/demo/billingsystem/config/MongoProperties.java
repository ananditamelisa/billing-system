package com.demo.billingsystem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "billing.system.mongodb")
@Data
public class MongoProperties {

  private String host;
  private String database;
}
