package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class EditPersonPage {
    @FindBy(how = How.ID, using = "name")
    private WebElement name;
    @FindBy(how = How.ID, using = "job")
    private WebElement job;
    @FindBy(how = How.XPATH, using = "//*[text()='Edit']")
    private WebElement editButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Cancel']")
    private WebElement cancelButton;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html?id=1";
    }

    public void editName(String names) {
        name.clear();
        name.sendKeys(names);
    }

    public void editJob(String jobs) {
        job.clear();
        job.sendKeys(jobs);
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }
}
