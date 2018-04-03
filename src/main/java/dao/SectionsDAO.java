package dao;

import model.SectionsEntity;

import java.util.List;

public interface SectionsDAO {
    void insertSection(SectionsEntity section);
    void updateSection(SectionsEntity section);
    void deleteSection(SectionsEntity section);

    SectionsEntity getSectionById(int sectionId);

    List<SectionsEntity> getSections();
}
