package sia.messageingestor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sia.messageingestor.dto.MessageDTO;
import sia.messageingestor.model.Message;
import sia.messageingestor.repository.MessageRepository;
import sia.messageingestor.service.MessageService;

import static org.mockito.Mockito.*;

class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveMessage() {
        MessageDTO messageDTO = new MessageDTO("Test content", "Test sender");
        messageService.saveMessage(messageDTO);
        verify(messageRepository, times(1)).save(any(Message.class));
    }

    @Test
    void testSaveMessageNull() {
        messageService.saveMessage(null);
        verify(messageRepository, never()).save(any(Message.class));
    }
}
