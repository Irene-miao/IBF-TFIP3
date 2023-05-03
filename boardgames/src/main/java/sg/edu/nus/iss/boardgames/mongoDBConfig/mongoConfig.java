package sg.edu.nus.iss.boardgames.mongoDBConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class mongoConfig {
    
    @Value("${spring.data.mongodb.uri}")
    private String connectionString;

    @Value("${spring.data.mongodb.database}")
    private String database;

    private MongoClient client = null;
    
    @Bean
    public MongoClient mongoClient(){
        if (null == client) {
            client = MongoClients.create(connectionString);
        }
        return client;
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), database);
    }
}
