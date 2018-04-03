package service;

import dao.SectionsDAO;
import model.SectionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class SectionsManagerImpl implements SectionsManager {
    @Autowired
    private SectionsDAO sectionDAO;

    //@Override
    @Transactional
    public void insertSection(SectionsEntity section) {
        sectionDAO.insertSection(section);
    }

    @Transactional
    public void updateSection(SectionsEntity section) {
        sectionDAO.updateSection(section);
    }

    //@Override
    @Transactional
    public void deleteSection(SectionsEntity section) {
        sectionDAO.deleteSection(section);
    }

    //@Override
    @Transactional
    public SectionsEntity getSectionById(int sectionId) {
        return sectionDAO.getSectionById(sectionId);
    }

    //@Override
    @Transactional
    public List<SectionsEntity> getSections() {
        return sectionDAO.getSections();
    }
}
