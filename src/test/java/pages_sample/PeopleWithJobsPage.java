package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.*;

public class PeopleWithJobsPage {
    @FindBy(how = How.XPATH, using = "//*[text()='Add person']")
    private WebElement addPersonButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Reset List']")
    private WebElement resetListButton;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/*[contains(@class, 'w3-closebtn editbtn w3-padding w3-margin-right w3-medium')]")
    private WebElement editIcon;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/*[contains(@class, 'w3-closebtn closebtn w3-padding w3-margin-right w3-medium')]")
    private WebElement deleteIcon;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/span[3]")
    private WebElement nameCheck1;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']/span[4]")
    private WebElement jobCheck1;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[3]")
    private WebElement nameCheck2;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[4]")
    private WebElement jobCheck2;
    @FindBy(how = How.CSS, using = "span.name")
    private List<WebElement> listPeople;



    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs";
    }

    public void clickAddPersonButtton() {
        addPersonButton.click();
    }

    public void clickResetListButtton() {
        resetListButton.click();
    }

    public void clickEditIcon() {
        editIcon.click();
    }

    public void clickDeleteIcon() {
        deleteIcon.click();
    }

    public void checkname(String names) {
        assertEquals(names, nameCheck1.getText());
    }

    public void checkjob(String jobs) {
        assertEquals(jobs, jobCheck1.getText());
    }

    public void checkListRemoved() {
       assertEquals(2,listPeople.size());

    }
    public void checkListRemovedafteradded() {
        assertEquals(3,listPeople.size());

    }

}
