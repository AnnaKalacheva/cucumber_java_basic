package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class NewPersonPage {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;
    @FindBy(how = How.TAG_NAME, using = ".w3-input")
    private List<WebElement> nameAndJobInput;
    @FindBy(how = How.CSS, using = "#modal_button:first-child")
    private WebElement addButton;
    @FindBy(how = How.ID, using = "addPersonBtn")
    private WebElement clearAllFieldsButton;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html";
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void iEnterNameAndJob(Map<String, String> valuesToEnter) {
        for (Map.Entry<String, String> inputValue : valuesToEnter.entrySet()) {
            if (inputValue.getKey().equals("name")) {
                enterName(inputValue.getValue());
            }
            if (inputValue.getKey().equals("job")) {
                enterJob(inputValue.getValue());
            }
        }
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void clickClearAllFieldsButton() {
        clearAllFieldsButton.click();
    }

    public void clearedFields() {
        assertTrue("".equals(nameInput.getText() + jobInput.getText()));
    }
}
