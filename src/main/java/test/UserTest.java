package test;

import config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.*;
import model.*;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

@Test
@ContextConfiguration(classes = {AppConfig.class})
public class UserTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private UserManager userManager;

    @DataProvider
    public Object[][] usersToInsert() {
        UserEntity regularUser = new UserEntity();
        regularUser.setLogin("testUser");
        regularUser.setName("Username");
        regularUser.setSurname("UserSurname");
        regularUser.setIsModerator((byte) 1);
        regularUser.setPassword("userPassword");
        regularUser.setRegistrationDate(new java.sql.Timestamp(System.currentTimeMillis()));

        UserEntity nullUser = null;

        return new Object[][]{
            {regularUser, true},
            {nullUser, false},
        };
    }

    @DataProvider
    public Object[][] usersToDelete() {
        UserEntity regularUser = userManager.getUser("testUser");
        //UserEntity constraintedUser = userManager.getUser("usedUser");
        UserEntity nullUser = null;

        return new Object[][]{
            {regularUser, true},
            {nullUser, false}//,
           // {constraintedUser, false}
        };
    }

    @DataProvider
    public Object[][] usersToUpdate() {
        UserEntity regular = userManager.getUserById(2);

        return new Object[][]{
                {regular, true},
        };
    }

    @DataProvider
    public Object[][] loginsToGet() {
        return new Object[][]{
                {"dronperminov", true},
                {"unexistinglogin", false},
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
                {"Andrew", "Perminov", true},
                {"Incorrect", "Name", false}
        };
    }

    @Test
    public void getUsersTest() {
        int amount = userManager.getUsers().size();
        assertNotNull(amount);
    }

    @Test(dataProvider = "usersToInsert")
    public void insertUserTest(UserEntity newUser, Boolean expected) {
        try {
            int amount = userManager.getUsers().size();
            userManager.insertUser(newUser);

            int amountAfterInsert = userManager.getUsers().size();
            assertEquals(amountAfterInsert, amount + 1);
        } catch (Exception e) {
            assertFalse(expected);
        } catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "usersToDelete")
    public void deleteUserTest(UserEntity removed, Boolean expected) {
        try {
            int amount = userManager.getUsers().size();
            userManager.deleteUser(removed);
            int amountAfterDelete = userManager.getUsers().size();

            assertEquals(amountAfterDelete, amount - 1);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "usersToUpdate")
    public void updateUserTest(UserEntity updated, Boolean expected) {
        try {
            String pass = updated.getPassword();
            String newPass = "12345678";

            updated.setPassword(newPass);
            userManager.updateUser(updated);

            UserEntity user = userManager.getUser(updated.getLogin());
            assertEquals(newPass, user.getPassword());

            // Restore
            updated.setPassword(pass);
            userManager.updateUser(updated);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "loginsToGet")
    public void getAccountTest(String login, Boolean expected) {
        try {
            UserEntity user = userManager.getUser(login);
            assertNotNull(user);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "idsToGet")
    public void getAccountByIdTest(int id, Boolean expected) {
        try {
            UserEntity user = userManager.getUserById(id);
            assertNotNull(user);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "namesToGet")
    public void getAccountByName(String firstName, String secondName, Boolean expected) {
        try {
            List<UserEntity> users = userManager.getUsersByName(firstName, secondName);
            assertNotNull(users);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }
}
