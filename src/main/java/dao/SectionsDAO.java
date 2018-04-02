package dao;

import java.util.List;
import model.SectionsEntity;

public interface SectionsDAO {
    void insertSections(SectionsEntity section);
    void updateSections(SectionsEntity section);

    SectionsEntity getSectionsById(int sectionId);

    List<SectionsEntity> getSections();
}
