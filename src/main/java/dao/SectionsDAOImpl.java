package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import model.SectionsEntity;

@Repository
public class SectionsDAOImpl extends HibernateDaoSupport implements SectionsDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public SectionsDAOImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    public void updateSections(SectionsEntity section) {
        sessionFactory.getCurrentSession().update(section);
    }

    //@Override
    public void insertSections(SectionsEntity section) {
        sessionFactory.getCurrentSession().save(section);
    }

    //@Override
    public SectionsEntity getSectionsById(int sectionId) {
        return (SectionsEntity) sessionFactory.getCurrentSession().get(SectionsEntity.class, sectionId);
    }

    //@Override
    @SuppressWarnings("unchecked")
    public List<SectionsEntity> getSections() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SectionsEntity.class);
        return criteria.list();
    }
}
