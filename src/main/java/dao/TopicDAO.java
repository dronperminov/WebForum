package dao;

import java.util.List;
import model.TopicEntity;

public interface TopicDAO {
    void insertTopic(TopicEntity topic);
    void updateTopic(TopicEntity topic);

    TopicEntity getTopicById(int topicId);

    List<TopicEntity> getTopics();
}
