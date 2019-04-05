package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PeopleWithJobsAddingPage {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobTitleInput;
    @FindBy(how = How.CSS, using = "#modal_button")
    private WebElement addButton;

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterJobTitle(String jobTitle) {
        jobTitleInput.clear();
        jobTitleInput.sendKeys(jobTitle);
    }

    public void clickAddButton() {
        addButton.click();
    }


}
