package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;

public class Task2Page {

    //inputs

    @FindBy(how = How.XPATH, using = "//*[@id=\"name\"]")
    private WebElement nameInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"surname\"]")
    private WebElement surnameInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"job\"]")
    private WebElement jobInput;

    @FindBy(how = How.XPATH, using = "//*[@id=\"dob\"]")
    private WebElement dateInput;





    //language check

    @FindBy(how = How.XPATH, using = "//*[@id=\"english\"]")
    private WebElement englishCheck;

    @FindBy(how = How.XPATH, using = "//*[@id=\"french\"]")
    private WebElement frenchCheck;

    @FindBy(how = How.XPATH, using = "//*[@id=\"spanish\"]")
    private WebElement spanishCheck;


    //gender check options

    @FindBy(how = How.XPATH, using = "//*[@id=\"male\"]")
    private WebElement maleOption;

    @FindBy(how = How.XPATH, using = "//*[@id=\"female\"]")
    private WebElement femaleOption;


    //status select options

    @FindBy(how = How.XPATH, using = "//*[@id=\"status\"]")
    private WebElement selectStatus;

    @FindBy(how = How.XPATH, using = "//*[@id=\"status\"]/option[1]")
    private WebElement employeeStatus;

    @FindBy(how = How.XPATH, using = "//*[@id=\"status\"]/option[2]")
    private WebElement internStatus;

    @FindBy(how = How.XPATH, using = "//*[@id=\"status\"]/option[3]")
    private WebElement contractorStatus;


    //buttons

    @FindBy(how = How.XPATH, using = "//*[@id=\"modal_button\"]")
    private WebElement addButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"modal_button\"]")
    private WebElement cancelButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"addPersonBtn\"]")
    private WebElement addPersonButton1;

    @FindBy (how = How.XPATH, using = "//*[@id=\"person3\"]/span[1]")
    private WebElement editPerson;

    @FindBy (how = How.XPATH, using ="//span[contains(@onclick, 'deletePerson(3)')]")
    private WebElement deletePerson;

    @FindBy(how = How.XPATH, using = "//div/button[contains(@onclick, 'resetListOfPeople()')]")
    private WebElement resetList;

    @FindBy (how = How.XPATH, using = "//div/button[contains(@onclick, 'openModalForAddPerson()')]")
    private WebElement clearData;



    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }


//buttons

    public void addpersonButton() {
        addPersonButton1.click();
    }

    public void savePersonData() {
        addButton.click();
    }

    public void cancelButton() {
        cancelButton.click();
    }




    //inputs

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


    //calendar

    public void enterDate(String date) throws InterruptedException {
        dateInput.clear();
        dateInput.sendKeys(date);

    }


    //languages

    public void spanishLanguage() throws Exception {
        spanishCheck.click();

    }


    //gender selection
    public void selectMaleGender() {
        maleOption.click();
    }

    public void selectFemaleGender() {
        femaleOption.click();
    }


    //status options
    public void statusSelectionIntern(String status) {
        Select dropdown = new Select(internStatus);
        assertEquals(status, dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Employee");
    }


    public void statusIntern (String intern1){

    }

    public void addAPersonNow (){

        addButton.click();
    }

    public void editNewPerson(){
        editPerson.click();
    }

    public void deleteNewPerson (){
    deletePerson.click();
    }

    public void resetPersonList(){
        resetList.click();
    }

    public void clearDataNow() {
        clearData.click();
    }

    public void checkIfDataCleared(){
        assertEquals("",nameInput);

    }

}
