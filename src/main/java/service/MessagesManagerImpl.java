package service;

import java.util.List;

import dao.MessagesDAO;
import model.MessagesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class MessagesManagerImpl implements MessagesManager {
    @Autowired
    private MessagesDAO messageDAO;

    @Transactional
    public void updateMessage(MessagesEntity message) {
        messageDAO.updateMessage(message);
    }

    //@Override
    @Transactional
    public void insertMessage(MessagesEntity message) {
        messageDAO.insertMessage(message);
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