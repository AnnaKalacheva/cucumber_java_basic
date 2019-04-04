package pages_sample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static junit.framework.TestCase.assertEquals;

public class NumberPage {
    @FindBy(how = How.ID, using = "numb")
    private WebElement numberInput;
    @FindBy(how = How.XPATH, using = "//button[.='Submit']")
    private WebElement submitBtn;
    @FindBy(how = How.ID, using = "ch1_error")
    private WebElement errorMsg;

    public void enterNumber(String number) {
        numberInput.clear();
        numberInput.sendKeys(number);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public void checkErrorMessage(String message) {
        assertEquals(message, errorMsg.getText());
    }

    public void checkAnswer(String message, Alert alert) {
        assertEquals(message, alert.getText());
    }

    public void clickAlertOK(Alert alert) {
        alert.accept();
    }
}
