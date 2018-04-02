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

    @Transactional
    public void updateSections(SectionsEntity section) {
        sectionDAO.updateSections(section);
    }

    //@Override
    @Transactional
    public void insertSections(SectionsEntity section) {
        sectionDAO.insertSections(section);
    }

    //@Override
    @Transactional
    public SectionsEntity getSectionsById(int sectionId) {
        return sectionDAO.getSectionsById(sectionId);
    }

    //@Override
    @Transactional
    public List<SectionsEntity> getSections() {
        return sectionDAO.getSections();
    }
}
