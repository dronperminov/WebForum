package dao;

import model.SectionsEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SectionsDAOImpl extends HibernateDaoSupport implements SectionsDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public SectionsDAOImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }

    //@Override
    public void insertSection(SectionsEntity section) {
        sessionFactory.getCurrentSession().save(section);
    }

    public void updateSection(SectionsEntity section) {
        sessionFactory.getCurrentSession().update(section);
    }

    //@Override
    public void deleteSection(SectionsEntity section) {
        sessionFactory.getCurrentSession().delete(section);
    }

    //@Override
    public SectionsEntity getSectionById(int sectionId) {
        return (SectionsEntity) sessionFactory.getCurrentSession().get(SectionsEntity.class, sectionId);
    }

    //@Override
    @SuppressWarnings("unchecked")
    public List<SectionsEntity> getSections() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(SectionsEntity.class);
        return criteria.list();
    }
}
