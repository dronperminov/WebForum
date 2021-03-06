package service;

import dao.TopicDAO;
import model.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //@override
    @Transactional
    public TopicEntity getTopicByName(String topicName) {return topicDAO.getTopicByName(topicName); }

    //@Override
    @Transactional
    public List<TopicEntity> getTopics() {
        return topicDAO.getTopics();
    }
}
