package test;

import config.AppConfig;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.*;
import java.util.List;

import static org.testng.Assert.*;

@Test
@ContextConfiguration(classes = {AppConfig.class})
public class MessagesTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MessagesManager MessagesManager;
    @Autowired
    private TopicManager TopicManager;
    @Autowired
    private UserManager UserManager;

    @DataProvider
    public Object[][] MessagesToInsert() {
        MessagesEntity regularMessage = new MessagesEntity();
        TopicEntity topic = TopicManager.getTopicById(1);
        UserEntity user = UserManager.getUserById(1);

        regularMessage.setTopicByTopicId(topic);
        regularMessage.setUserByAuthorId(user);
        regularMessage.setSendDate(new java.sql.Timestamp(System.currentTimeMillis()));
        regularMessage.setContent("TestContent");

        MessagesEntity nullMessage = null;

        return new Object[][]{
                {regularMessage, true},
                {nullMessage, false},
        };
    }

    @DataProvider
    public Object[][] MessagesToDelete() {
        List<MessagesEntity> messages = MessagesManager.getMessages();
        MessagesEntity message = messages.get(messages.size() - 1);

        MessagesEntity regularMessage = MessagesManager.getMessageById(message.getMessageId());
        MessagesEntity nullMessage = null;

        return new Object[][]{
                {regularMessage, true},
                {nullMessage, false},
        };
    }

    @DataProvider
    public Object[][] idsToGet() {
        return new Object[][]{
                {1, true},
                {4096, false},
        };
    }

    /************************************** TESTS *********************************************/

    @Test()
    public void getMessagesTest() {
        int amount = MessagesManager.getMessages().size();
        assertNotNull(amount);
    }

    @Test(dataProvider = "MessagesToInsert", priority = 1)
    public void insertMessageTest(MessagesEntity newMessage, Boolean expected) {
        try {
            int amount = MessagesManager.getMessages().size();
            MessagesManager.insertMessage(newMessage);
            int amountAfterInsert = MessagesManager.getMessages().size();

            assertEquals(amountAfterInsert, amount + 1);
        } catch (Exception e) {
            assertFalse(expected);
        } catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "MessagesToDelete", priority = 2)
    public void deleteMessageTest(MessagesEntity removed, Boolean expected) {
        try {
            int amount = MessagesManager.getMessages().size();
            MessagesManager.deleteMessage(removed);
            int amountAfterDelete = MessagesManager.getMessages().size();

            assertEquals(amountAfterDelete, amount - 1);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "idsToGet")
    public void getMessageByIdTest(int id, Boolean expected) {
        try {
            MessagesEntity Message = MessagesManager.getMessageById(id);
            assertNotNull(Message);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }
}