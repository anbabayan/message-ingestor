package sia.messageingestor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sia.messageingestor.dto.MessageDTO;
import sia.messageingestor.listeners.KafkaListeners;
import sia.messageingestor.service.MessageService;

import static org.mockito.Mockito.*;

class KafkaListenersTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private KafkaListeners kafkaListeners;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListener() {
        MessageDTO messageDTO = new MessageDTO("Test content", "Test sender");
        kafkaListeners.listener(messageDTO);
        verify(messageService, times(1)).saveMessage(messageDTO);
    }
}
