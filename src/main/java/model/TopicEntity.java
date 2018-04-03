package model;

import javax.persistence.*;

@Entity
@Table(name = "topic", schema = "webforum", catalog = "")
public class TopicEntity {
    private int topicId;
    private String name;
    private String description;
    private SectionsEntity sectionsBySectionId;

    @Id
    @Column(name = "topicId", nullable = false)
    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 500)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 3000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopicEntity that = (TopicEntity) o;

        if (topicId != that.topicId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "sectionId", referencedColumnName = "sectionId")
    public SectionsEntity getSectionsBySectionId() {
        return sectionsBySectionId;
    }

    public void setSectionsBySectionId(SectionsEntity sectionsBySectionId) {
        this.sectionsBySectionId = sectionsBySectionId;
    }
}
