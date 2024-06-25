package sia.messageingestor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.messageingestor.config.KafkaTopicConfig;
import sia.messageingestor.dto.MessageDTO;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controller class for handling message-related requests.
 */
@RestController
@RequestMapping(path = "api/v1/messages")
public class MessageController {
    private static final Logger logger = Logger.getLogger(MessageController.class.getName());
    private final KafkaTemplate<String, Object> template;

    public MessageController(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    /**
     * Endpoint to publish a message to a Kafka topic.
     *
     * @param messageDTO the message to be published
     * @return ResponseEntity with status code and message
     */
    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody MessageDTO messageDTO) {
        logger.log(Level.INFO, "Received message from " + messageDTO.getSender() + " to be sent to Kafka topic");
        try {
            template.send(KafkaTopicConfig.TOPIC_NAME, messageDTO);
            return new ResponseEntity<>("Message published successfully.", HttpStatus.OK);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to send message to Kafka topic: " + e.getMessage(), e);
            return new ResponseEntity<>("Failed to publish message.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
