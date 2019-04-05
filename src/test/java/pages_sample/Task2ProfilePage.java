package pages_sample;

import gherkin.lexer.Th;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Task2ProfilePage {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameField;

    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameField;

    @FindBy(how = How.ID, using = "job")
    private WebElement jobField;

    @FindBy(how = How.ID, using = "dob")
    private WebElement dateField;

    @FindBy(how = How.XPATH, using = "//*[@name='gender']")
    private List<WebElement> genderRadio;

    @FindBy(how = How.ID, using = "status")
    private WebElement employeeStatus;

    @FindBy(how = How.ID, using = "modal_button")
    private WebElement addToListBtn;

    @FindBy(how = How.CLASS_NAME, using = "w3-btn")
    private List<WebElement> buttons;

    @FindBy(how = How.CLASS_NAME, using = "w3-check")
    private List<WebElement> checkboxes;


    public void addToList() {
        addToListBtn.click();
    }

    public void editBtnToSave(){
        buttons.get(0).click();
    }

    public void clearAllBtn() {
        buttons.get(0).click();
    }

    public void checkAllCleared() {
        assertEquals("", nameField.getAttribute("value"));
        assertEquals("", jobField.getAttribute("value"));
        assertEquals("", surnameField.getAttribute("value"));
        assertEquals("", dateField.getAttribute("value"));
    }

    public void enterUserInformation(String jobTitle, String status) {
        jobField.clear();
        jobField.sendKeys(jobTitle);

        Select statusSelect = new Select(employeeStatus);
        statusSelect.selectByVisibleText(status);
    }

    public void enterUserName(String name, String surname) {
        nameField.clear();
        nameField.sendKeys(name);
        surnameField.clear();
        surnameField.sendKeys(surname);
    }

    public void enterDateOfBirth(String dateOfBirth) {
        dateField.clear();
        dateField.sendKeys(dateOfBirth);
    }

    public void enterGender(String gender) {
        if (gender.equals("female")) {
            genderRadio.get(1).click();
        } else genderRadio.get(0).click();
    }

    public void chooseLanguages(List<String> languages) {
        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkboxes.get(i).isSelected()) {
                checkboxes.get(i).click();
            }
        }

        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i).equals("English")) {
                checkboxes.get(0).click();
            }
            if (languages.get(i).equals("French")) {
                checkboxes.get(1).click();
            }
            if (languages.get(i).equals("Spanish")) {
                checkboxes.get(2).click();
            }
        }
    }

}

