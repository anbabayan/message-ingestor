package sia.messageingestor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaTemplate;
import sia.messageingestor.config.KafkaTopicConfig;
import sia.messageingestor.controller.MessageController;
import sia.messageingestor.dto.MessageDTO;

import static org.mockito.Mockito.*;

class MessageControllerTest {

    @Mock
    private KafkaTemplate<String, Object> kafkaTemplate;

    @InjectMocks
    private MessageController messageController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPublish() {
        MessageDTO messageDTO = new MessageDTO("Test content", "Test sender");
        messageController.publishMessage(messageDTO);
        verify(kafkaTemplate, times(1)).send(KafkaTopicConfig.TOPIC_NAME, messageDTO);
    }
}
