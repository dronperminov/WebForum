package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "messages", schema = "webforum")
public class MessagesEntity {
    private int messageId;
    private String content;
    private Timestamp sendDate;
    private String filesUrl;
    private UserEntity userByAuthorId;
    private TopicEntity topicByTopicId;

    @Id
    @Column(name = "messageId", nullable = false)
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "content", nullable = false, length = 3000)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "sendDate", nullable = false)
    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    @Basic
    @Column(name = "filesUrl", nullable = true, length = 1000)
    public String getFilesUrl() {
        return filesUrl;
    }

    public void setFilesUrl(String filesUrl) {
        this.filesUrl = filesUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessagesEntity that = (MessagesEntity) o;

        if (messageId != that.messageId) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (sendDate != null ? !sendDate.equals(that.sendDate) : that.sendDate != null) return false;
        if (filesUrl != null ? !filesUrl.equals(that.filesUrl) : that.filesUrl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = messageId;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (sendDate != null ? sendDate.hashCode() : 0);
        result = 31 * result + (filesUrl != null ? filesUrl.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "authorId", referencedColumnName = "userId", nullable = false)
    public UserEntity getUserByAuthorId() {
        return userByAuthorId;
    }

    public void setUserByAuthorId(UserEntity userByAuthorId) {
        this.userByAuthorId = userByAuthorId;
    }

    @ManyToOne
    @JoinColumn(name = "topicId", referencedColumnName = "topicId", nullable = false)
    public TopicEntity getTopicByTopicId() {
        return topicByTopicId;
    }

    public void setTopicByTopicId(TopicEntity topicByTopicId) {
        this.topicByTopicId = topicByTopicId;
    }
}
