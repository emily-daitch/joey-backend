package com.joey.app;

import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Mongo mongoInstance = new Mongo();
        MongoDatabase database = mongoInstance.getDatabase();
        System.out.println("Connected to the database successfully");
        System.out.println( "Hello World!" );
    }
}
