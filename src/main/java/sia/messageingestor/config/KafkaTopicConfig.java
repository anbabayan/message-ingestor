package sia.messageingestor.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Configuration class for Kafka topic settings.
 */
@Configuration
public class KafkaTopicConfig {
    public static final String TOPIC_NAME = "polixis";

    /**
     * Bean configuration for creating a Kafka topic.
     *
     * @return the Kafka topic
     */
    @Bean
    public NewTopic taskTopic() {
        return TopicBuilder.name(TOPIC_NAME).build();
    }
}
