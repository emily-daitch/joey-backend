package com.joey.app;

import com.mongodb.client.MongoDatabase;
import io.dropwizard.setup.Environment;
import io.dropwizard.jdbi3.JdbiFactory;
import org.jdbi.v3.core.Jdbi;
// TODO
//import io.dropwizard.setup.Bootstrap;
//import io.dropwizard.setup.Environment;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(final String[] args) throws Exception {
        Mongo mongoInstance = new Mongo();
        MongoDatabase database = mongoInstance.getDatabase();
        System.out.println("Connected to the database successfully");
        System.out.println( "Hello World!" );
        new App().run(args);
    }

    @Override
    public void run(
      final JoeyConfiguration configuration, final Environment environment
    ) {
      final JdbiFactory factory = new JdbiFactory();
      final Jdbi jdbi = factory.build(environment,
        configuration.getDataSourceFactory(),
        "postgresql"
      );

    }
}
