package com.neo.config.props;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

/**
 * @author neo
 */
@Data
@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

  private MongoProperties primary = new MongoProperties();
  private MongoProperties secondary = new MongoProperties();
}
