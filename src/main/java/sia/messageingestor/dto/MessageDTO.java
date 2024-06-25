package sia.messageingestor.dto;

/**
 * Data transfer object for message information.
 */
public class MessageDTO {
    private String content;
    private String sender;

    public MessageDTO() {
    }

    public MessageDTO(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                '}';
    }
}
