package service;

import dao.MessagesDAO;
import model.MessagesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class MessagesManagerImpl implements MessagesManager {
    @Autowired
    private MessagesDAO messageDAO;

    //@Override
    @Transactional
    public void insertMessage(MessagesEntity message) {
        messageDAO.insertMessage(message);
    }

    @Transactional
    public void updateMessage(MessagesEntity message) {
        messageDAO.updateMessage(message);
    }

    @Transactional
    public void deleteMessage(MessagesEntity message) {
        messageDAO.deleteMessage(message);
    }

    //@Override
    @Transactional
    public MessagesEntity getMessageById(int messageId) {
        return messageDAO.getMessageById(messageId);
    }

    //@Override
    @Transactional
    public List<MessagesEntity> getMessages() {
        return messageDAO.getMessages();
    }
}
