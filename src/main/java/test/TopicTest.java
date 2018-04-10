package test;

import config.AppConfig;
import model.TopicEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.TopicManager;

import static org.testng.Assert.*;

@Test
@ContextConfiguration(classes = {AppConfig.class})
public class TopicTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TopicManager topicManager;

    private String testName = "NewInsertedTopic";

    @DataProvider
    public Object[][] topicsToInsert() {
        TopicEntity regularTopic = new TopicEntity();
        regularTopic.setName(testName);

        TopicEntity nullTopic = null;

        return new Object[][]{
                {regularTopic, true},
                {nullTopic, false},
        };
    }

    @DataProvider
    public Object[][] topicsToDelete() {
        TopicEntity regularTopic = topicManager.getTopicByName(testName);
        TopicEntity nullTopic = null;

        return new Object[][]{
                {regularTopic, true},
                {nullTopic, false},
        };
    }

    @DataProvider
    public Object[][] idsToGet() {
        return new Object[][]{
                {1, true},
                {4096, false},
        };
    }

    @DataProvider
    public Object[][] namesToGet() {
        return new Object[][]{
                { testName, true},
                { "Noname", false}
        };
    }

    /************************************** TESTS *********************************************/

    @Test()
    public void getTopicsTest() {
        int amount = topicManager.getTopics().size();
        assertNotNull(amount);
    }

    @Test(dataProvider = "topicsToInsert", priority = 1)
    public void insertTopicTest(TopicEntity newTopic, Boolean expected) {
        try {
            int amount = topicManager.getTopics().size();
            topicManager.insertTopic(newTopic);
            int amountAfterInsert = topicManager.getTopics().size();

            assertEquals(amountAfterInsert, amount + 1);
        } catch (Exception e) {
            assertFalse(expected);
        } catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "topicsToDelete", priority = 3)
    public void deleteTopicTest(TopicEntity removed, Boolean expected) {
        try {
            int amount = topicManager.getTopics().size();
            topicManager.deleteTopic(removed);
            int amountAfterDelete = topicManager.getTopics().size();

            assertEquals(amountAfterDelete, amount - 1);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "idsToGet")
    public void getTopicByIdTest(int id, Boolean expected) {
        try {
            TopicEntity topic = topicManager.getTopicById(id);
            assertNotNull(topic);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "namesToGet", priority = 2)
    public void getTopicByNameTest(String topicName, Boolean expected) {
        try {
            TopicEntity topics = topicManager.getTopicByName(topicName);
            assertNotNull(topics);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }
}