package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.assertEquals;

public class EditPersonPage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"name\"]")
    private WebElement nameInput;
    @FindBy(how = How.XPATH, using = "//*[@id=\"job\"]")
    private WebElement jobInput;
    @FindBy(how = How.XPATH, using = "//*[text()='Edit']")
    private WebElement editButton;
    @FindBy(how = How.XPATH, using = "//*[text()='Cancel']")
    private WebElement cancelButton;

    public void editName (String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void editJob (String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void clickEdit () {
        editButton.click();
    }


}
