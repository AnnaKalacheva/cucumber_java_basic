package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.*;

public class AddNewPersonPage {
    @FindBy(how = How.ID, using = "name")
    private WebElement name;
    @FindBy(how = How.ID, using = "job")
    private WebElement job;
    @FindBy(how = How.XPATH, using = "//*[text()='Add']")
    private WebElement addButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Cancel']")
    private WebElement cancelButton;
    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement clearAllFieldsButton;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html";
    }

    public void entername(String names) {
        name.clear();
        name.sendKeys(names);
    }

    public void enterjob(String jobs) {
        job.clear();
        job.sendKeys(jobs);
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    public void clickclearAllFieldsButton() {
        clearAllFieldsButton.click();
        assertEquals("", name.getText());
        assertEquals("", job.getText());
    }



}
