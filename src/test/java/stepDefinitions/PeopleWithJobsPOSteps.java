package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.PeopleWithJobs;
import pages_sample.PeopleWithJobs_NewPerson;

import java.util.List;
import java.util.Map;

public class PeopleWithJobsPOSteps {

    private WebDriver driver;
    static PeopleWithJobs peopleWjobs;
    static PeopleWithJobs_NewPerson peopleWjobs_NewPerson;

    public PeopleWithJobsPOSteps() {
        this.driver = Hooks.driver;
        peopleWjobs = PageFactory.initElements(Hooks.driver, PeopleWithJobs.class);
        peopleWjobs_NewPerson = PageFactory.initElements(Hooks.driver, PeopleWithJobs_NewPerson.class);
    }

    @Given("^I am on People with jobs page$")
    public void iAmOnPage() throws Throwable {
        driver.get(peopleWjobs.peopleWithJobsUrl());
    }

    @When("^I click Add person button:$")
    public void iClickAddPersonButton() throws Throwable {
        peopleWjobs.clickAddPerson();
    }

    @Then("^I'm redirected to a new person registration page$")
    public void iMRedirectedToANewPersonRegistrationPage() throws Throwable {
        driver.get(peopleWjobs_NewPerson.newPersonPageUrl());
    }

    @And("^I fill all fields$")
    public void iFillAllFields() throws Throwable {

    }

    @And("^I enter values$")
    public void iEnterValues() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I enter values in fields:$")
    public void iEnterValuesInFields(Map<String, String> valuesToEnter) throws Throwable {
        peopleWjobs_NewPerson.enterName(valuesToEnter.get("Name"));
        peopleWjobs_NewPerson.enterSurname(valuesToEnter.get("Surname"));
        peopleWjobs_NewPerson.enterJob(valuesToEnter.get("Job"));
        peopleWjobs_NewPerson.enterDateOfBirth(valuesToEnter.get("Date of birth"));
    }

    @And("^I click on language checkboxes:$")
    public void iSelectLanguage(List<String> languageList) throws Throwable {
        for (String languageValue : languageList) {
            driver.findElement(By.id(languageValue.toLowerCase())).click();
        }
    }

    @And("^I click on gender: (.*)$")
    public void iChooseGender(String gender) throws Throwable {
        peopleWjobs_NewPerson.selectGender(gender);
    }

    @And("^I select Employee status: (.*)$")
    public void iSelectEmployeeStatus(String employeeStatus) throws Throwable {
        peopleWjobs_NewPerson.selectEmployeeStatus(employeeStatus);
    }

    @Then("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        peopleWjobs_NewPerson.clickAdd();
    }

    @When("^I click pencil to edit person for person: (.*)$")
    public void iClickPencilEditPersonForJillWatson(String id) throws Throwable {
            driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(" + id + ")']")).click();
    }

    @And("^I enter a new date of birth: (.*)$")
    public void iChangeDateOfBirthTo(String dob) throws Throwable {
        peopleWjobs_NewPerson.enterDateOfBirth(dob);
    }

    @Then("^I click Edit button$")
    public void iClickEditButton() throws Throwable {
        driver.findElement(By.xpath("//button[text()='Edit']")).click();
    }

    @When("^I click cross to remove person: (\\d+)$")
    public void iClickCrossToRemovePerson(int id) throws Throwable {
        driver.findElement(By.xpath("//span[@onclick='deletePerson(" + id + ")']")).click();
    }
}
