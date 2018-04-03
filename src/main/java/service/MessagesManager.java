package service;

import model.MessagesEntity;

import java.util.List;

public interface MessagesManager {
    void insertMessage(MessagesEntity message);
    void updateMessage(MessagesEntity message);
    void deleteMessage(MessagesEntity message);

    MessagesEntity getMessageById(int messageId);

    List<MessagesEntity> getMessages();
}
