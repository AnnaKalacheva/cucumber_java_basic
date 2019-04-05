package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;


public class PeopleWithJobs_NewPerson {

    //Fields for new person
    @FindBy(how = How.XPATH, using = "//input[@id='name']")
    private WebElement nameInput;
    @FindBy(how = How.XPATH, using = "//input[@id='surname']")
    private WebElement surnameInput;
    @FindBy(how = How.XPATH, using = "//input[@id='job']")
    private WebElement jobInput;
    @FindBy(how = How.XPATH, using = "//input[@id='dob']")  //Date format: dd/mm/yyyy
    private WebElement dateOfBirthInput;
    @FindBy(how = How.XPATH, using = "//input[@name='language']")
    private List<WebElement> languageSelect;
    @FindBy(how = How.XPATH, using = "//input[@name='gender']")
    private List<WebElement> genderSelect;
    @FindBy(how = How.XPATH, using = "//select[@id='status']") //????????????
    private WebElement employeeStatus;


    //Buttons for new person
    @FindBy(how = How.XPATH, using = "//button[text()='Clear all fields']")
    private WebElement btnClearAllFields;
    @FindBy(how = How.XPATH, using = "//button[text()='Add']")
    private WebElement btnAdd;
    @FindBy(how = How.XPATH, using = "//span[@class='Cancel']")
    private WebElement btnCancel;


    public String newPersonPageUrl() {
        return "https://kristinek.github.io/site/tasks/enter_a_new_person.html";
    }

    public void clickClearAllFields() {
        btnClearAllFields.click();
    }

    public void clickAdd() {
        btnAdd.click();
    }

    public void clickCancel() {
        btnCancel.click();
    }

    private void checkDefaultEmployeeStatusSelected() {
        Select dropdown = new Select(employeeStatus);
        assertEquals("Employee", dropdown.getFirstSelectedOption().getText());
    }

    public void checkThatNewPersonFormIsClean() {
        assertTrue(nameInput.getText().isEmpty());
        assertTrue(surnameInput.getText().isEmpty());
        assertTrue(jobInput.getText().isEmpty());
        assertTrue(dateOfBirthInput.getText().isEmpty());
        assertTrue(languageSelect.get(0).isSelected());
        assertFalse(languageSelect.get(1).isSelected());
        assertFalse(languageSelect.get(2).isSelected());
        for (int i = 0; i < 3; i++) {
            assertFalse(genderSelect.get(i).isSelected());
        }
        checkDefaultEmployeeStatusSelected();
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

    public void enterDateOfBirth(String birthDate) {
        dateOfBirthInput.clear();
        dateOfBirthInput.sendKeys(birthDate);
    }

    public void selectEnglishLanguage(String englishLanguage) {
        if (!languageSelect.get(0).isSelected() && languageSelect.get(0).getAttribute("id").equals("english"))
            languageSelect.get(0).click();
    }

    public void selectFrenchLanguage(String franchLanguage) {
        if (!languageSelect.get(1).isSelected() && languageSelect.get(1).getAttribute("id").equals("french"))
            languageSelect.get(1).click();
    }

    public void selectSpanishLanguage(String spanishLanguage) {
        if (!languageSelect.get(2).isSelected() && languageSelect.get(2).getAttribute("id").equals("spanish"))
            languageSelect.get(2).click();
    }

    public void selectGender(String gender) {
        if (gender.equals("Male")) {
            genderSelect.get(0).click();
        } else if (gender.equals("Female")) {
            genderSelect.get(1).click();
        }
    }

    public void selectEmployeeStatus(String status) {
        Select dropdown = new Select(employeeStatus);
        switch(status) {
            case "Intern":
                dropdown.selectByValue("intern");
                break;
            case "Contractor":
                dropdown.selectByValue("contractor");
                break;
            default:
                dropdown.selectByValue("employee");
        }
    }
}