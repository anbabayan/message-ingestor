package sia.messageingestor.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import sia.messageingestor.config.KafkaTopicConfig;
import sia.messageingestor.dto.MessageDTO;
import sia.messageingestor.service.MessageService;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Component class for handling Kafka message listeners.
 */
@Component
public class KafkaListeners {
    private static final Logger logger = Logger.getLogger(KafkaListeners.class.getName());
    private final MessageService messageService;

    public KafkaListeners(MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Method to listen for messages on a Kafka topic and process them.
     *
     * @param messageDTO the message received from the Kafka topic
     */
    @KafkaListener(topics = KafkaTopicConfig.TOPIC_NAME, groupId = "groupId")
    public void listener(@NonNull MessageDTO messageDTO) {
        logger.log(Level.INFO, "Topic " + KafkaTopicConfig.TOPIC_NAME + " received new message from sender " + messageDTO.getSender());
        messageService.saveMessage(messageDTO);
    }
}
