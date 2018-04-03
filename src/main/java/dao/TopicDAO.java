package dao;

import model.TopicEntity;

import java.util.List;

public interface TopicDAO {
    void insertTopic(TopicEntity topic);
    void updateTopic(TopicEntity topic);
    void deleteTopic(TopicEntity topic);

    TopicEntity getTopicById(int topicId);

    List<TopicEntity> getTopics();
}
