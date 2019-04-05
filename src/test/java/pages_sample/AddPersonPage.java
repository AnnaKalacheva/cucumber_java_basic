package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddPersonPage {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;
    @FindBy(how = How.XPATH, using = "//*[text()='Add']")
    private WebElement addButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Clear all fields']")
    private WebElement clearAllButton;


    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterJob (String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void clickAdd () {
        addButton.click();
    }

    public void clickClearAll () {
        clearAllButton.click();
    }

    public void checkFormIsClean () {
        assertEquals("", nameInput.getText());
        assertEquals("", jobInput.getText());
    }

}
