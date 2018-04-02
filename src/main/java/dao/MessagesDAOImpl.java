package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.MessagesEntity;

@Repository
public class MessagesDAOImpl extends HibernateDaoSupport implements MessagesDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public MessagesDAOImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    public void updateMessage(MessagesEntity message) {
        sessionFactory.getCurrentSession().update(message);
    }

    //@Override
    public void insertMessage(MessagesEntity message) {
        sessionFactory.getCurrentSession().save(message);
    }

    //@Override
    public MessagesEntity getMessageById(int messageId) {
        return (MessagesEntity) sessionFactory.getCurrentSession().get(MessagesEntity.class, messageId);
    }

    //@Override
    @SuppressWarnings("unchecked")
    public List<MessagesEntity> getMessages() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MessagesEntity.class);
        return criteria.list();
    }
}
