package com.joey.app;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Mongo {
    private MongoClient mongo;
    private MongoDatabase database;

    public Mongo() {
        // Creating a Mongo client 
        this.mongo = MongoClients.create(); 
        // Accessing the database 
        this.database = mongo.getDatabase("myDb"); 
    }

    public MongoDatabase getDatabase() {
        return this.database;
    }
}
