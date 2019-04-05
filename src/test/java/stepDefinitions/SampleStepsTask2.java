package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages_sample.AddPerson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import pages_sample.PeopleWithJobs;

public class SampleStepsTask2 {
    private WebDriver driver;
    static PeopleWithJobs peopleWithJobsPage;
    static AddPerson addPersonPage;


    public SampleStepsTask2() {
        this.driver = Hooks.driver;

        peopleWithJobsPage = PageFactory.initElements(Hooks.driver, PeopleWithJobs.class);
        addPersonPage = PageFactory.initElements(Hooks.driver, AddPerson.class);
    }

    @Given("^I am on Add Person page$")
    public void iAmOnAddPersonPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person_with_a_job.html");
    }

    @Given("^I am on People with jobs page$")
    public void iAmOnPeopleWithJobsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs");
    }


    @When("^Input name$")
    public void inputName(String name) {
        addPersonPage.inputName(name);
    }

    @And("^Input job$")
    public void inputJob2(String job) {
        addPersonPage.inputJob(job);
    }

    @And("^Press Add button$")
    public void pressAddButton() {
        addPersonPage.pressButtonAdd();
    }


    @When("^Input name \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        addPersonPage.inputName(name);
    }

    @And("^Input job \"([^\"]*)\"$")
    public void inputJob(String job) throws Throwable {
        addPersonPage.inputJob(job);
    }


    @And("^Press edit Button$")
    public void pressEditButton() {
        addPersonPage.pressEditButton();
    }

    @And("^Press Reset List$")
    public void pressResetList() {
        peopleWithJobsPage.resetPersonList();
    }

    @When("^Press edit Button Pencil$")
    public void pressEditButtonPencil() {
        peopleWithJobsPage.pressEditButtonByIndex(0);
    }

    @Then("^The Person is edited with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void thePersonIsEditedWithAnd(String name, String job) {
        assertEquals(name, driver.findElement(By.xpath("//span[@class='w3-xlarge name']")).getText());
        assertEquals(job, driver.findElement(By.xpath("//span[@class='job']")).getText());
    }


    @Then("^The new  Person with \"([^\"]*)\"and \"([^\"]*)\" is created$")
    public void theNewPersonOnPeopleWithJobsIsCreated(String name, String job) {
        int index = peopleWithJobsPage.findIndexOfLastPerson();
        WebElement nameOfLastPerson = peopleWithJobsPage.findNameIndex(index);
        WebElement jobOfLastPerson = peopleWithJobsPage.findJobIndex(index);
        assertEquals(name, nameOfLastPerson.getText());
        assertEquals(job, jobOfLastPerson.getText());
    }

    @When("^I press Add person$")
    public void iPressAddPerson() {
        peopleWithJobsPage.pressAddPerson();
    }

    @Then("^Original list of People left$")
    public void originalListOfPeopleLeft() {
        peopleWithJobsPage.originalListOfPeopleLeft();
    }

    @When("^Press cross icon$")
    public void pressCrossIcon() {
        peopleWithJobsPage.findCrossIndex(0).click();
    }

    @Then("^Person is removed from list$")
    public void personIsRemovedFromList() {
        peopleWithJobsPage.listWithRemovedPerson();
    }
}