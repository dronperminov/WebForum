package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.TopicEntity;

@Repository
public class TopicDAOImpl extends HibernateDaoSupport implements TopicDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public TopicDAOImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    //@Override
    public void insertTopic(TopicEntity topic) {
        sessionFactory.getCurrentSession().save(topic);
    }

    public void updateTopic(TopicEntity topic) {
        sessionFactory.getCurrentSession().update(topic);
    }

    public void deleteTopic(TopicEntity topic) {
        sessionFactory.getCurrentSession().delete(topic);
    }

    //@Override
    public TopicEntity getTopicById(int topicId) {
        return (TopicEntity) sessionFactory.getCurrentSession().get(TopicEntity.class, topicId);
    }

    //@Override
    @SuppressWarnings("unchecked")
    public List<TopicEntity> getTopics() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TopicEntity.class);
        return criteria.list();
    }
}
