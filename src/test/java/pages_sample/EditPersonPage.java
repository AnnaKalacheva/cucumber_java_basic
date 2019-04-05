package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Map;

public class EditPersonPage {

    @FindBy(how = How.XPATH, using = "//*[@onclick='editPersonWithJob(0)']")
    private WebElement editButton;
    @FindBy(how = How.CSS, using = "#person0 > span.w3-xlarge.name")
    private WebElement editPersonName;
    @FindBy(how = How.CSS, using = "#person0 > span.job")
    private WebElement editPersonJob;
    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;


    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html?id=0";
    }

    public void clickEditButton() {
        editButton.click();
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void iEditNameAndJob(Map<String, String> valuesToEnter) {
        for (Map.Entry<String, String> inputValue : valuesToEnter.entrySet()) {
            if (inputValue.getKey().equals("name")) {
                enterName(inputValue.getValue());
            }
            if (inputValue.getKey().equals("job")) {
                enterJob(inputValue.getValue());
            }
        }
    }

    public String editPersonText() {
        return editPersonName.getText() + ", " + editPersonJob.getText();
    }
}
