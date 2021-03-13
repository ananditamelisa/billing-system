package com.demo.billingsystem.config;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

  private static final String MONGO_URI = "mongodb://%s/%s?";

  @Autowired
  private MongoProperties mongoProperties;

  @Override
  public MongoClient mongoClient() {
    String mongoUri = String.format(MONGO_URI, mongoProperties.getHost(),
        mongoProperties.getDatabase());
    return MongoClients.create(new ConnectionString(mongoUri));
  }

  @Override
  protected String getDatabaseName() {
    return mongoProperties.getDatabase();
  }
}
