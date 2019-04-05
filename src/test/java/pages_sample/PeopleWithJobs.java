package pages_sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PeopleWithJobs {

    //Fields
    @FindBy(how = How.XPATH, using = "//span[@class='name']")
    private List<WebElement> name;
    @FindBy(how = How.XPATH, using = "//span[@class='surname']")
    private List<WebElement> surname;
    @FindBy(how = How.XPATH, using = "//span[@class='job']")
    private List<WebElement> job;
    @FindBy(how = How.XPATH, using = "//span[@class='dob']")
    private List<WebElement> dateOfBirth;
    @FindBy(how = How.XPATH, using = "//span[@class='language']")
    private List<WebElement> language;
    @FindBy(how = How.XPATH, using = "//span[@class='gender']")
    private List<WebElement> gender;
    @FindBy(how = How.XPATH, using = "//span[@class='status']")
    private List<WebElement> employeeStatus;

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

    public void clickAddPerson(){ btnAddPerson.click();}
    public void clickResetList(){ btnResetList.click();}
    public void clickEditPerson(){ btnEditPerson.click();}
    public void clickDeletePerson(){ btnDeletePerson.click();}

}
