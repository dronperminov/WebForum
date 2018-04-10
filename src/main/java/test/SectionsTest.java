package test;

import config.AppConfig;
import model.SectionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.SectionsManager;
import java.util.List;

import static org.testng.Assert.*;

@Test
@ContextConfiguration(classes = {AppConfig.class})
public class SectionsTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private SectionsManager SectionsManager;

    @DataProvider
    public Object[][] SectionsToInsert() {
        SectionsEntity regularSection = new SectionsEntity();
        regularSection.setSectionName("TestName");

        SectionsEntity nullSection = null;

        return new Object[][]{
                {regularSection, true},
                {nullSection, false},
        };
    }

    @DataProvider
    public Object[][] SectionsToDelete() {
        List<SectionsEntity> sections = SectionsManager.getSections();
        SectionsEntity section = sections.get(sections.size() - 1);

        SectionsEntity regularSection = SectionsManager.getSectionById(section.getSectionId());
        SectionsEntity constraintSection = SectionsManager.getSectionById(1);
        SectionsEntity nullSection = null;

        return new Object[][]{
                {regularSection, true},
                {constraintSection, false},
                {nullSection, false},
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
    public void getSectionsTest() {
        int amount = SectionsManager.getSections().size();
        assertNotNull(amount);
    }

    @Test(dataProvider = "SectionsToInsert", priority = 1)
    public void insertSectionTest(SectionsEntity newSection, Boolean expected) {
        try {
            int amount = SectionsManager.getSections().size();
            SectionsManager.insertSection(newSection);
            int amountAfterInsert = SectionsManager.getSections().size();

            assertEquals(amountAfterInsert, amount + 1);
        } catch (Exception e) {
            assertFalse(expected);
        } catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "SectionsToDelete", priority = 2)
    public void deleteSectionTest(SectionsEntity removed, Boolean expected) {
        try {
            int amount = SectionsManager.getSections().size();
            SectionsManager.deleteSection(removed);
            int amountAfterDelete = SectionsManager.getSections().size();

            assertEquals(amountAfterDelete, amount - 1);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }

    @Test(dataProvider = "idsToGet")
    public void getSectionByIdTest(int id, Boolean expected) {
        try {
            SectionsEntity Section = SectionsManager.getSectionById(id);
            assertNotNull(Section);
        } catch (Exception e) {
            assertFalse(expected);
        }
        catch (java.lang.AssertionError e) {
            assertFalse(expected);
        }
    }
}