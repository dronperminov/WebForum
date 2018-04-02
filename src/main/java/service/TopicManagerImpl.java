package service;

import java.util.List;

import dao.TopicDAO;
import model.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class TopicManagerImpl implements TopicManager {
    @Autowired
    private TopicDAO topicDAO;

    //@Override
    @Transactional
    public void insertTopic(TopicEntity topic) {
        topicDAO.insertTopic(topic);
    }

    @Transactional
    public void updateTopic(TopicEntity topic) {
        topicDAO.updateTopic(topic);
    }

    //@Override
    @Transactional
    public void deleteTopic(TopicEntity topic) {
        topicDAO.deleteTopic(topic);
    }

    //@Override
    @Transactional
    public TopicEntity getTopicById(int topicId) {
        return topicDAO.getTopicById(topicId);
    }

    //@Override
    @Transactional
    public List<TopicEntity> getTopics() {
        return topicDAO.getTopics();
    }
}
