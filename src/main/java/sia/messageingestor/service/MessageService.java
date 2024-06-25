package sia.messageingestor.service;

import org.springframework.stereotype.Service;
import sia.messageingestor.dto.MessageDTO;
import sia.messageingestor.model.Message;
import sia.messageingestor.repository.MessageRepository;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Service class for handling message operations.
 */
@Service
public class MessageService {
    private static final Logger logger = Logger.getLogger(MessageService.class.getName());
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    /**
     * Saves a message to the database.
     *
     * @param messageDTO the message data transfer object to be saved
     */
    public void saveMessage(MessageDTO messageDTO) {
        if (Objects.isNull(messageDTO)) {
            logger.log(Level.INFO, "MessageDTO cannot be null");
            return;
        }
        final Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setSender(messageDTO.getSender());
        logger.log(Level.INFO, "Saving a new message from " + message.getSender() + " to DB");
        messageRepository.save(message);
    }
}
