package service;

import java.util.List;

import dao.SectionsDAO;
import model.SectionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class SectionsManagerImpl implements SectionsManager {
    @Autowired
    private SectionsDAO sectionDAO;

    //@Override
    @Transactional
    public void insertSections(SectionsEntity section) {
        sectionDAO.insertSection(section);
    }

    @Transactional
    public void updateSections(SectionsEntity section) {
        sectionDAO.updateSection(section);
    }

    //@Override
    @Transactional
    public void deleteSections(SectionsEntity section) {
        sectionDAO.deleteSection(section);
    }

    //@Override
    @Transactional
    public SectionsEntity getSectionsById(int sectionId) {
        return sectionDAO.getSectionById(sectionId);
    }

    //@Override
    @Transactional
    public List<SectionsEntity> getSections() {
        return sectionDAO.getSections();
    }
}
