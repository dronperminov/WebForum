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

    public void updateTopic(TopicEntity Topic) {
        sessionFactory.getCurrentSession().update(Topic);
    }

    //@Override
    public void insertTopic(TopicEntity Topic) {
        sessionFactory.getCurrentSession().save(Topic);
    }

    //@Override
    public TopicEntity getTopicById(int TopicId) {
        return (TopicEntity) sessionFactory.getCurrentSession().get(TopicEntity.class, TopicId);
    }

    //@Override
    @SuppressWarnings("unchecked")
    public List<TopicEntity> getTopics() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(TopicEntity.class);
        return criteria.list();
    }
}
