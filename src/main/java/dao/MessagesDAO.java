package dao;

import java.util.List;
import model.MessagesEntity;

public interface MessagesDAO {
    void insertMessage(MessagesEntity message);
    void updateMessage(MessagesEntity message);
    void deleteMessage(MessagesEntity message);

    MessagesEntity getMessageById(int messageId);

    List<MessagesEntity> getMessages();
}
