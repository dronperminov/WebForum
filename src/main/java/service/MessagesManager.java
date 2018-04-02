package service;

import java.util.List;
import model.MessagesEntity;

public interface MessagesManager {
    void insertMessage(MessagesEntity message);
    void updateMessage(MessagesEntity message);
    void deleteMessage(MessagesEntity message);

    MessagesEntity getMessageById(int messageId);

    List<MessagesEntity> getMessages();
}
