package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddPerson {

    @FindBy(how = How.CSS, using = "#name")
    private WebElement nameInput;

    @FindBy(how = How.CSS, using = "#job")
    private WebElement jobInput;




    @FindBy(how = How.XPATH, using = "//button[contains(.,'Cancel')]")
    private WebElement buttonCancel;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'Clear')]")
    private WebElement buttonClearAllFields;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'Edit')]")
    private WebElement buttonEdit;

    @FindBy(how = How.CSS, using = "#modal_button")
    private WebElement buttonAdd;

    public void inputName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void inputJob(String name) {
        jobInput.clear();
        jobInput.sendKeys(name);
    }

    public void pressButtonAdd() {
        buttonAdd.click();
    }

    public void pressEditButton(){
        buttonEdit.click();
    }
}