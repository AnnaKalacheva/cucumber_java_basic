package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class PeopleWithJobsPage {

    @FindBy(how = How.CSS, using = "#addPersonBtn")
    private WebElement addPersonButton;
    @FindBy(how = How.XPATH, using = "//*[@onclick= 'resetListOfPeople()']")
    private WebElement resetListButton;
    @FindBy(how = How.CLASS_NAME, using = "w3-padding-16")
    private List<WebElement> listOfPeopleFiel;
    @FindBy(how = How.CLASS_NAME, using = "name")
    private List<WebElement> listOfPeopleFieldName;
    @FindBy(how = How.CLASS_NAME, using = "job")
    private List<WebElement> listOfPeopleFieldJobTitle;
    @FindBy(how = How.CLASS_NAME, using = "editbtn")
    private List<WebElement> listOfEditButtonPerson;
    @FindBy(how = How.CLASS_NAME, using = "closebtn")
    private List<WebElement> listOfDeleteButtonPerson;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html";
    }

    public void clickAddPersonButton() {
        addPersonButton.click();
    }

    public void checkNewLine() {
        assertEquals(4, listOfPeopleFiel.size());
        assertTrue(listOfPeopleFieldName.get(3).isDisplayed());
        assertTrue(listOfPeopleFieldJobTitle.get(3).isDisplayed());
        assertEquals("Test", listOfPeopleFieldName.get(3).getText());
        assertEquals("Tester", listOfPeopleFieldJobTitle.get(3).getText());
    }

    public void clickEditButtonFirstPerson() {
        listOfEditButtonPerson.get(0).click();
    }

    public void checkFirstPersonInfoEdited() {
        assertEquals("Test2", listOfPeopleFieldName.get(0).getText());
        assertEquals("Tester2", listOfPeopleFieldJobTitle.get(0).getText());
    }

    public void ClickDeletePersonButton() {
        listOfDeleteButtonPerson.get(0).click();
    }

    public void isPersonIsRemoved() {
        assertEquals(2, listOfPeopleFiel.size());
        assertEquals("Jill", listOfPeopleFieldName.get(0).getText());
        assertEquals("Support", listOfPeopleFieldJobTitle.get(0).getText());
    }

    public void clickResetButton() {
        resetListButton.click();
        assertEquals(3, listOfPeopleFiel.size());
        assertEquals("Mike", listOfPeopleFieldName.get(0).getText());
        assertEquals("Web Designer", listOfPeopleFieldJobTitle.get(0).getText());
        assertEquals("Jill", listOfPeopleFieldName.get(1).getText());
        assertEquals("Support", listOfPeopleFieldJobTitle.get(1).getText());
        assertEquals("Jane", listOfPeopleFieldName.get(2).getText());
        assertEquals("Accountant", listOfPeopleFieldJobTitle.get(2).getText());
    }
}
