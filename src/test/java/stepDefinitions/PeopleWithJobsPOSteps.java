package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
    public void iAmOnPage() {
        driver.get(peopleWjobs.peopleWithJobsUrl());
    }

    @When("^I click Add person button:$")
    public void iClickAddPersonButton() {
        peopleWjobs.clickAddPerson();
    }

    @Then("^I'm redirected to a new person registration page$")
    public void iMRedirectedToANewPersonRegistrationPage() {
        driver.get(peopleWjobs_NewPerson.newPersonPageUrl());
    }

    @And("^I fill all fields$")
    public void iFillAllFields() {

    }

    @And("^I enter values in fields:$")
    public void iEnterValuesInFields(Map<String, String> valuesToEnter) throws Throwable{
        for(Map.Entry<String, String> value : valuesToEnter.entrySet()) {
            driver.findElement(By.id(value.getKey())).clear();
            driver.findElement(By.id(value.getKey())).sendKeys(value.getValue());

        }
        driver.findElement(By.tagName("body")).click();
        Thread.sleep(1000);
    }

    @And("^I click on language checkboxes:$")
    public void iSelectLanguage(List<String> languageList) {
        for (String languageValue : languageList) {
            driver.findElement(By.id(languageValue.toLowerCase())).click();
        }
    }

    @And("^I click on gender: (.*)$")
    public void iChooseGender(String gender) {
        peopleWjobs_NewPerson.selectGender(gender);
    }

    @And("^I select Employee status: (.*)$")
    public void iSelectEmployeeStatus(String employeeStatus) {
        peopleWjobs_NewPerson.selectEmployeeStatus(employeeStatus);
    }

    @Then("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        peopleWjobs_NewPerson.clickAdd();
    }

    @When("^I click pencil to edit person: (.*)$")
    public void iClickPencilEditPersonForJillWatson(String personNameSurname) {
        for (int index = 0; index < peopleWjobs.personsList().size(); index++) {
            if (peopleWjobs.personsList().get(index).equals(personNameSurname)) {
                driver.findElement(By.xpath("//span[@onclick='openModalForEditPerson(" + index + ")']")).click();
            }
        }
    }

    @And("^I enter a new date of birth: (.*)$")
    public void iChangeDateOfBirthTo(String dob) throws Throwable {
        peopleWjobs_NewPerson.enterDateOfBirth(dob);
    }

    @Then("^I click Edit button$")
    public void iClickEditButton() throws Throwable{
        driver.findElement(By.xpath("//button[text()='Edit']")).click();
    }

    @When("^I click cross to remove person: (.*)$")
    public void iClickCrossToRemovePerson(String personNameSurname) throws Throwable {
        System.out.println("\nAmount of persons before deletion: " + peopleWjobs.personsList().size());
        for (int index = 0; index < peopleWjobs.personsList().size(); index++) {
            if (peopleWjobs.personsList().get(index).equals(personNameSurname)) {
                driver.findElement(By.xpath("//span[@onclick='deletePerson(" + index + ")']")).click();
            }
        }
    }

    @Then("^I see person is removed$")
    public void iSeePersonIsRemoved() {
        System.out.println("\nAmount of persons after deletion: " + peopleWjobs.personsList().size());
    }

    @Then("^I click Reset list button$")
    public void iClickResetListButton() {
        peopleWjobs.clickResetList();
    }

    @Then("^I click Clear all fields button$")
    public void iClickClearAllFieldsButton() throws Throwable {
        peopleWjobs_NewPerson.clickClearAllFields();
    }

    @Then("^I see that registration form was reset to default$")
    public void iSeeThatRegistrationFormWasResetToDefault()  throws Throwable {
        peopleWjobs_NewPerson.checkThatNewPersonFormIsClean();
        Thread.sleep(5000);
    }
}
