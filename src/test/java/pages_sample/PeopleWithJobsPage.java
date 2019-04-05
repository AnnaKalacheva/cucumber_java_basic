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
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[2]")
    private WebElement editButtonFirstPerson;
    @FindBy(how = How.CLASS_NAME, using = "w3-padding-16")
    private List<WebElement> listOfPeopleFiel;
    @FindBy(how = How.CLASS_NAME, using = "name")
    private List<WebElement> listOfPeopleFieldName;
    @FindBy(how = How.CLASS_NAME, using = "job")
    private List<WebElement> listOfPeopleFieldJobTitle;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html";
    }

    public void clickAddPersonButton() {
        addPersonButton.click();
    }

    public void checkNewLine() {
        //assertEquals(4, listOfPeopleFiel.size());
        assertTrue(listOfPeopleFieldName.get(3).isDisplayed());
        assertTrue(listOfPeopleFieldJobTitle.get(3).isDisplayed());
        assertEquals("Test", listOfPeopleFieldName.get(3).getText());
        assertEquals("Tester", listOfPeopleFieldJobTitle.get(3).getText());
    }

    public void clickEditButtonFirstPerson() {
        editButtonFirstPerson.click();
    }
}
