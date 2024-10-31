package nxt.perfume.connector;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class CustomMongoDBConfig {
    @Value("${mongo.connection.string}")
    private String MONGO_DB_CONNECTION_STRING;

    @Value("${mongo.connection.database}")
    private String MONGO_DB_NAME;

    @Bean("mongoTemplate")
    public MongoTemplate getMongoTemplate() {
        return new MongoTemplate(MongoClients.create(MONGO_DB_CONNECTION_STRING), MONGO_DB_NAME);
    }
}
