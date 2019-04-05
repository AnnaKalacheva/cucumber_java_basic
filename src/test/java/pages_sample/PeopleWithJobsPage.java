package pages_sample;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class PeopleWithJobsPage {

    @FindBy(how = How.XPATH, using = "//*[text()='Add person']")
    private WebElement addPersonButton;
    @FindBy(how = How.XPATH, using = "//*[@class='w3-xlarge name']")
    private List<WebElement> listOfNames;
    @FindBy(how = How.CSS, using = "span.job")
    private List<WebElement> listOfjobs;
    @FindBy(how = How.CSS, using = "span.w3-closebtn.closebtn")
    private List<WebElement> listOfRemoveBtns;
    @FindBy(how = How.XPATH, using = "span.w3-closebtn.editbtn")
    private List<WebElement> listOfEditBtns;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[3]")
    private WebElement person0Name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[4]")
    private WebElement person0Job;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/span[3]")
    private WebElement person1Name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person1\"]/span[4]")
    private WebElement person1Job;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/span[3]")
    private WebElement person2Name;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person2\"]/span[4]")
    private WebElement person2Job;
    @FindBy(how = How.XPATH, using = "//*[text()='Reset List']")
    private WebElement resetListButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[2]/i")
    private WebElement editPerson0button;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[3]")
    private WebElement editedPersonsName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[4]")
    private WebElement editedPersonsJob;
    @FindBy(how = How.XPATH, using = "//*[@id=\"person0\"]/span[1]")
    private WebElement removePerson0button;
    @FindBy(how = How.ID, using = "person0")
    private WebElement person0;

    @FindBy(how = How.CSS, using = ".w3-check[type='checkbox']")
    private List<WebElement> checkBoxes;

    private WebDriver driver;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html";
    }

    public void clickAddPerson() {
        addPersonButton.click();
    }

    public void checkAddedPersonsName (String name) {
        WebElement newname = (listOfNames.get(listOfNames.size()-1));
        assertEquals(name, newname.getText());}


    public void checkAddedPersonsJob (String name) {
        WebElement newjob = (listOfjobs.get(listOfjobs.size()-1));
        assertEquals(name, newjob.getText());}


    public void clickEditPerson0() {
        editPerson0button.click();
    }

    public void checkEditedPersonsName (String name) {
        assertEquals(name, editedPersonsName.getText());
    }

    public void checkEditedPersonsJob (String job) {
        assertEquals(job, editedPersonsJob.getText());
    }

    public void clickResetListButton() {
        resetListButton.click();
    }

    public void checkPerson0Name(String person0name) {
        assertEquals(person0name,person0Name.getText());
    }
    public void checkPerson1Name(String person1name) {
        assertEquals(person1name,person1Name.getText());
    }
    public void checkPerson2Name(String person2name) {
        assertEquals(person2name,person2Name.getText());
    }

    public void checkPerson0Job(String person0job) {
        assertEquals(person0job,person0Job.getText());
    }
    public void checkPerson1Job(String person1job) {
        assertEquals(person1job,person1Job.getText());
    }
    public void checkPerson2Job(String person2job) {
        assertEquals(person2job,person2Job.getText());
    }

    public void checkOriginalListValues() {
        checkPerson0Name("Mike");
        checkPerson0Job("Web Designer");
        checkPerson1Name("Jill");
        checkPerson1Job("Support");
        checkPerson2Name("Jane");
        checkPerson2Job("Accountant");
    }

    public void checkpersonRemovedFromList (){
        assertTrue(listOfNames.size() < 3);
    }

    public void clickonremove (int removebuttonindex) {
        (listOfRemoveBtns.get(removebuttonindex)).click();}

}
