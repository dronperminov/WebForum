package dao;

import java.util.List;
import model.SectionsEntity;

public interface SectionsDAO {
    void insertSection(SectionsEntity section);
    void updateSection(SectionsEntity section);
    void deleteSection(SectionsEntity section);

    SectionsEntity getSectionById(int sectionId);

    List<SectionsEntity> getSections();
}
