package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.junit.Assert.*;

public class JobPage {
    @FindBy(how = How.XPATH, using = "//*[text()='Add person']")
    private WebElement buttonAddPerson;
    @FindBy(how = How.XPATH, using = "//*[@id='name']")
    private WebElement yourName;
    @FindBy(how = How.XPATH, using = "//*[@id='job']")
    private WebElement yourJobTitle;
    @FindBy(how = How.XPATH, using = "//*[text()='Add']")
    private WebElement buttonAdd;
    @FindBy(how = How.XPATH, using = "//*[@id='person3']/span[3]")
    private WebElement addedName;
    @FindBy(how = How.XPATH, using = "//*[@id='person3']/span[4]")
    private WebElement addedJobTitle;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[2]")
    private WebElement buttonEditOnFirstPage;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']/span[1]")
    private WebElement buttonRemove;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']")
    private WebElement personRemoved;
    @FindBy(how = How.XPATH, using = "//*[text()='Reset List']")
    private WebElement buttonReset;
    @FindBy(how = How.XPATH, using = "//*[@id='person0']") // //*[@id="person0"]
    private WebElement originalPerson1;
    @FindBy(how = How.XPATH, using = "//*[@id='person1']") // //*[@id='person0']
    private WebElement originalPerson2;
    @FindBy(how = How.XPATH, using = "//*[@id='person2']")
    private WebElement originalPerson3;

    public String getPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html";
    }

    public void clickAddPersonButton() {
        //driver.findElement(By.xpath("//*[text()='Add person']")).click();
        buttonAddPerson.click();
    }

    public void enterPersonName(String personName) {
        yourName.sendKeys(personName);
    }

    public void enterJobTitle(String jobTitle) {
        yourJobTitle.sendKeys(jobTitle);
    }

    public void clickAddButton() {
        buttonAdd.click();
    }

    public void checkPersonAddedName(String name) {

        assertEquals(name, addedName.getText());
    }

    public void checkPersonAddedJobTitle(String title) {
        assertEquals(title, addedJobTitle.getText());
    }


    public void clickEditPerson() {
        buttonEditOnFirstPage.click();
    }

    public void editName(String name) {
        yourName.clear();
        yourName.sendKeys(name);

    }

    public void editJobTitle(String jobTitle) {
        yourJobTitle.clear();
        yourJobTitle.sendKeys(jobTitle);
    }


    public void removePerson() {
        buttonRemove.click();
    }

    public void checkPersonRemoved() {
        assertTrue(originalPerson1.isDisplayed());
        assertTrue(originalPerson2.isDisplayed());
      }

    public void pressResetButton() {
        buttonReset.click();
    }

    public void checkListIsOriginalAfterReset() {
        assertTrue(originalPerson1.isDisplayed());
        assertTrue(originalPerson2.isDisplayed());
        assertTrue(originalPerson3.isDisplayed());

    }
    public void clearAllInputFields() {
        yourName.clear();
        yourJobTitle.clear();
    }
    public void checkButtonClearWorks() {
        assertEquals("",yourName.getText());
        assertEquals("",yourJobTitle.getText());

    }
}

