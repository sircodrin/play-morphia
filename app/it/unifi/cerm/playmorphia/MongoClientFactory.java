package it.unifi.cerm.playmorphia;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.typesafe.config.Config;
import javax.inject.Inject;

/**
 * Created by morelli on 21/02/19.
 */
public class MongoClientFactory {

  protected Config config;
  protected boolean isTest;

  public MongoClientFactory(Config config) {
    this.config = config;
  }

  @Inject
  protected MongoClientFactory(Config config, boolean isTest) {
    this.config = config;
    this.isTest = isTest;
  }

  /**
   * Creates and returns a new instance of a MongoClient.
   *
   * @return a new MongoClient
   */
  public MongoClient createClient() {
    return MongoClients.create(getClientURI());
  }


  /**
   * Returns the database name associated with the current configuration.
   *
   * @return The database name
   */
  public String getDbName() {
    return config.getString("playmorphia.database");
  }

  protected String getClientURI() {
    return isTest
            ? config.getString("playmorphia.test-uri")
            : config.getString("playmorphia.uri");
  }

  /**
   * Returns the models folder name associated with the current configuration.
   *
   * @return The models folder name
   */
  public String getModels() {
    return config.getString("playmorphia.models");
  }

}