package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class PeopleWithJobs {

    //Fields
    @FindBy(how = How.XPATH, using = "//span[@class='name']")
    private List<WebElement> namesList;
    @FindBy(how = How.XPATH, using = "//span[@class='surname']")
    private List<WebElement> surnamesList;

    @FindBy(how = How.XPATH, using = "//span[@class='job']")
    private List<WebElement> jobsList;
    @FindBy(how = How.XPATH, using = "//span[@class='dob']")
    private List<WebElement> datesOfBirthList;
    @FindBy(how = How.XPATH, using = "//span[@class='language']")
    private List<WebElement> languagesList;
    @FindBy(how = How.XPATH, using = "//span[@class='gender']")
    private List<WebElement> gendersList;
    @FindBy(how = How.XPATH, using = "//span[@class='status']")
    private List<WebElement> employeeStatusesList;

    //Buttons
    @FindBy(how = How.XPATH, using = "//button[text()='Add person']")
    private WebElement btnAddPerson;
    @FindBy(how = How.XPATH, using = "//button[text()='Reset List']")
    private WebElement btnResetList;
    @FindBy(how = How.XPATH, using = "//span[@class='editbtn']")
    private WebElement btnEditPerson;
    @FindBy(how = How.XPATH, using = "//span[@class='closebtn']")
    private WebElement btnDeletePerson;


    public String peopleWithJobsUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people.html";
    }

    public void clickAddPerson() {
        btnAddPerson.click();
    }

    public void clickResetList() {
        btnResetList.click();
    }

    public List<String> personsList() {
        List<String> personsList = new ArrayList<>();
        for (int i = 0; i < namesList.size(); i++) {
            personsList.add(namesList.get(i).getText() + " " + surnamesList.get(i).getText());
        }
        return personsList;
    }

}
