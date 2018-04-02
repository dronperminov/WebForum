package model;

import javax.persistence.*;

@Entity
@Table(name = "sections", schema = "webforum", catalog = "")
public class SectionsEntity {
    private int sectionId;
    private String sectionName;

    @Id
    @Column(name = "sectionId", nullable = false)
    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    @Basic
    @Column(name = "sectionName", nullable = false, length = 300)
    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionsEntity that = (SectionsEntity) o;

        if (sectionId != that.sectionId) return false;
        if (sectionName != null ? !sectionName.equals(that.sectionName) : that.sectionName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sectionId;
        result = 31 * result + (sectionName != null ? sectionName.hashCode() : 0);
        return result;
    }
}
