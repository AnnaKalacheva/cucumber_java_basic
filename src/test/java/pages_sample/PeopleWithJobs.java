package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

import java.util.List;

public class PeopleWithJobs {
    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement heading;
    @FindBy(how = How.CSS, using = "#addPersonBtn:first-child")
    private WebElement addPersonButton;
    @FindBy(how = How.XPATH, using = "//*[contains(@onclick, 'resetListOfPeople()')]")
    private List<WebElement> resetList;
    @FindBy(how = How.XPATH, using = "//*[@ondrop=\"drop(event)\"]")
    private List<WebElement> persons;
    @FindBy(how = How.ID, using = "person0")
    private WebElement person1;
    @FindBy(how = How.ID, using = "person3")
    private WebElement newPerson;
    @FindBy(how = How.CSS, using = "#person3 > span.w3-xlarge.name")
    private WebElement newPersonName;
    @FindBy(how = How.CSS, using = "#person3 > span.job")
    private WebElement newPersonJob;
    @FindBy(how = How.XPATH, using = "//*[@onclick='openModalForEditPersonWithJob(0)']")
    private WebElement editButton;
    @FindBy(how = How.XPATH, using = "//*[@onclick='deletePerson(0)']")
    private WebElement deleteButton;
    @FindBy(how = How.XPATH, using = "//*[@onclick='resetListOfPeople()']")
    private WebElement resetListButton;


    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs";
    }

    public void clickAddPersonButton() {
        addPersonButton.click();
    }

    public int personListSize() {
        return persons.size();
    }

    public String newPersonAdded() {
        return newPersonName.getText() + " " + newPersonJob.getText();
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void clickDeleteButton() {
        deleteButton.click();
    }

    public void clickResetListButton() {
        resetListButton.click();
    }

}
