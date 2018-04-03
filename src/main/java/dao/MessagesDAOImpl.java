package dao;

import model.MessagesEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessagesDAOImpl extends HibernateDaoSupport implements MessagesDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public MessagesDAOImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    //@Override
    public void insertMessage(MessagesEntity message) {
        sessionFactory.getCurrentSession().save(message);
    }

    public void updateMessage(MessagesEntity message) {
        sessionFactory.getCurrentSession().update(message);
    }

    public void deleteMessage(MessagesEntity message) {
        sessionFactory.getCurrentSession().delete(message);
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
