package service;

import model.TopicEntity;

import java.util.List;

public interface TopicManager {
    void insertTopic(TopicEntity topic);
    void updateTopic(TopicEntity topic);
    void deleteTopic(TopicEntity topic);

    TopicEntity getTopicById(int topicId);
    TopicEntity getTopicByName(String topicName);

    List<TopicEntity> getTopics();
}
