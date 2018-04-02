package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.UserEntity;

@Repository
public class UserDAOImpl extends HibernateDaoSupport implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    public void updateUser(UserEntity user) {
        sessionFactory.getCurrentSession().update(user);
    }

    //@Override
    public void insertUser(UserEntity user) {
        sessionFactory.getCurrentSession().save(user);
    }

    //@Override
    public UserEntity getUserById(int userId) {
        return (UserEntity) sessionFactory.getCurrentSession().get(UserEntity.class, userId);
    }

    //@Override
    public UserEntity getUser(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from UserEntity where login = :login");
        query.setParameter("login", login);
        return (UserEntity) query.list().get(0);
    }

    //@Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> getUsers() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
        return criteria.list();
    }

    public List<UserEntity> getUsersByName(String name, String surname) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserEntity.class).
                add(Restrictions.like("name", name)).
                add(Restrictions.like("surname", surname));
        return criteria.list();
    }
}