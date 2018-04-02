package service;

import java.util.List;
import model.SectionsEntity;

public interface SectionsManager {
    void insertSections(SectionsEntity section);
    void updateSections(SectionsEntity section);

    SectionsEntity getSectionsById(int sectionId);

    List<SectionsEntity> getSections();
}
