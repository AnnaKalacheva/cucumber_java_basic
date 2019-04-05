package pages;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static junit.framework.TestCase.*;

public class FormPage {

    @FindBy(how = How.ID, using = "name")
    private WebElement nameInput;
    @FindBy(how = How.ID, using = "surname")
    private WebElement surnameInput;
    @FindBy(how = How.ID, using = "job")
    private WebElement jobInput;
    @FindBy(how = How.ID, using = "dob")
    private WebElement dateOfBirthBox;
    @FindBy(how = How.XPATH, using = "//input[@type='checkbox' and @name='language']")
    private List<WebElement> languageCheckboxes;
    @FindBy(how = How.XPATH, using = "//input[@type='radio' and @name='gender']")
    private List<WebElement> genderRadio;
    @FindBy(how = How.ID, using = "status")
    private WebElement statusSelect;
    @FindBy(how = How.XPATH, using = "//button[@id='modal_button' and .='Add']")
    private WebElement addButton;
    @FindBy(how = How.XPATH, using = "//button[@id='modal_button' and .='Edit']")
    private WebElement editButton;
    @FindBy(how = How.XPATH, using = "//button[@id='modal_button' and .='Cancel']")
    private WebElement cancelButton;
    @FindBy(how = How.XPATH, using = "//button[.='Clear all fields']")
    private WebElement clearButton;

    public void enterInput(String name, String value){
        switch (name){
            case "name":{
                enterName(value);
                break;
            }
            case "surname":{
                enterSurname(value);
                break;
            }
            case "job":{
                enterJob(value);
                break;
            }
            case "birthDate":{
                enterDateOfBirth(value);
                break;
            }
            default:{
                throw new InvalidArgumentException("invalid name of the input field");
            }
        }
    }

    public void enterName(String name) {
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterSurname(String surname) {
        surnameInput.clear();
        surnameInput.sendKeys(surname);
    }

    public void enterJob(String job) {
        jobInput.clear();
        jobInput.sendKeys(job);
    }

    public void enterDateOfBirth(String date) {
        dateOfBirthBox.clear();
        dateOfBirthBox.sendKeys(date);
    }

    public void selectLanguages(String languages) {
        for (WebElement checkbox: languageCheckboxes) {
            if (checkbox.isSelected()){
                checkbox.click();
            }
        }

        if (languages.isEmpty()){
            return;
        }

        String[] langArr = languages.split(", ");

        for (String lang: langArr) {
            switch (lang){
                case "English":{
                    languageCheckboxes.get(0).click();
                    break;
                }
                case "French":{
                    languageCheckboxes.get(1).click();
                    break;
                }
                case "Spanish":{
                    languageCheckboxes.get(2).click();
                    break;
                }
                default:{
                    throw new InvalidArgumentException("invalid language");
                }
            }
        }
    }

    public void selectGender(String gender) {
        if (gender.isEmpty()){
            return;
        }

        if (gender.equals("male")){
            genderRadio.get(0).click();
        } else if (gender.equals("female")) {
            genderRadio.get(1).click();
        } else {
            throw new InvalidArgumentException("invalid genre");
        }
    }

    public void selectEmployeeStatus(String status) {
        if (status.isEmpty()){
            throw new InvalidArgumentException("employee status is not selected");
        }

        Select select = new Select(statusSelect);

        if (Character.isLowerCase(status.charAt(0))){
            status = status.replaceFirst("^.",
                    Character.toString(Character.toUpperCase(status.charAt(0))));
        }

        select.selectByVisibleText(status);
    }

    public void clickAddBtn() {
        addButton.click();
    }

    public void clickEditBtn() {
        editButton.click();
    }

    public void clickCancelBtn() {
        cancelButton.click();
    }

    public void clickClearBtn(){
        clearButton.click();
    }

    public void checkInput(String name, String value){
        switch (name){
            case "name":{
                checkName(value);
                break;
            }
            case "surname":{
                checkSurname(value);
                break;
            }
            case "job":{
                checkJob(value);
                break;
            }
            case "birthDate":{
                checkDateOfBirth(value);
                break;
            }
            case "languages":{
                checkLanguages(value);
                break;
            }
            case "gender":{
                checkGender(value);
                break;
            }
            case "status":{
                checkEmployeeStatus(value);
                break;
            }
            default:{
                throw new InvalidArgumentException("invalid name of the input field");
            }
        }
    }

    public void checkName(String name) {
        assertEquals(name, nameInput.getText());
    }

    public void checkSurname(String surname) {
        assertEquals(surname, surnameInput.getText());
    }

    public void checkJob(String job) {
        assertEquals(job, jobInput.getText());
    }

    public void checkDateOfBirth(String date) {
        assertEquals(date, dateOfBirthBox.getText());
    }

    public void checkLanguages(String languages) {
        boolean[] landFlags = {false, false, false};

        if (!languages.isEmpty()){
            String[] langArr = languages.split(", ");
            for (String lang: langArr) {
                switch (lang){
                    case "English":{
                        landFlags[0] = true;
                        break;
                    }
                    case "French":{
                        landFlags[1] = true;
                        break;
                    }
                    case "Spanish":{
                        landFlags[2] = true;
                        break;
                    }
                    default:{
                        throw new InvalidArgumentException("invalid language");
                    }
                }
            }
        }

        for (int i = 0; i < languageCheckboxes.size(); i++) {
            assertEquals(landFlags[i], languageCheckboxes.get(i).isSelected());
        }
    }

    public void checkGender(String gender) {
        if (gender.equals("male")){
            assertTrue(genderRadio.get(0).isSelected());
        } else if (gender.equals("female")) {
            assertTrue(genderRadio.get(1).isSelected());
        } else if (gender.isEmpty()){
            assertFalse(genderRadio.get(0).isSelected());
            assertFalse(genderRadio.get(1).isSelected());
        } else {
            throw new InvalidArgumentException("invalid genre");
        }
    }

    public void checkEmployeeStatus(String status) {
        if (status.isEmpty()){
            throw new InvalidArgumentException("employee status is not selected");
        }

        Select select = new Select(statusSelect);

        if (Character.isLowerCase(status.charAt(0))){
            status = status.replaceFirst("^.",
                    Character.toString(Character.toUpperCase(status.charAt(0))));
        }

        assertEquals(status, select.getFirstSelectedOption().getText());
    }

}
