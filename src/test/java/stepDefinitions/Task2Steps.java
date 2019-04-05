package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.EditPersonPage;
import pages_sample.NewPersonPage;
import pages_sample.PeopleWithJobs;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task2Steps {

    private WebDriver driver;

    static PeopleWithJobs peopleWithJobs;
    static NewPersonPage newPersonPage;
    static EditPersonPage editPersonPage;
    private static int firstPersonsListSize;

    public Task2Steps() {
        this.driver = Hooks.driver;
        peopleWithJobs = PageFactory.initElements(Hooks.driver, PeopleWithJobs.class);
        newPersonPage = PageFactory.initElements(Hooks.driver, NewPersonPage.class);
        editPersonPage = PageFactory.initElements(Hooks.driver, EditPersonPage.class);
    }

    @Given("^I am on People with jobs page$")
    public void iAmOnPeopleWithJobsPage() throws Throwable {
        driver.get(peopleWithJobs.getPageUrl());
        firstPersonsListSize = setFirstPersonsListSize();
    }

    @When("^I click Add new person button$")
    public void iAddNewPersonButton() throws Throwable {
        peopleWithJobs.clickAddPersonButton();
    }

    @Then("^I see Enter a new person page$")
    public void iSeeEnterANewPersonPage() throws Throwable {
        assertEquals(driver.getCurrentUrl(), newPersonPage.getPageUrl());
    }

    @And("^I enter a new name and job:$")
    public void iEnterANewNameAndJob(Map<String, String> values) throws Throwable {
        newPersonPage.iEnterNameAndJob(values);
    }

    @And("^I click add button$")
    public void iClickAddButton() throws Throwable {
        newPersonPage.clickAddButton();
    }

    public int setFirstPersonsListSize() {
        driver.get(peopleWithJobs.getPageUrl());
        return peopleWithJobs.personListSize();
    }

    @And("^new person is added$")
    public void newPersonIsAdded() throws Throwable {
        assertTrue(firstPersonsListSize < peopleWithJobs.personListSize());
        assertEquals("Valentina Test Engineer", peopleWithJobs.newPersonAdded());
    }

    @And("^I am redirected on People with jobs page$")
    public void iRedirectOnPeopleWithJobsPage() throws Throwable {
        assertTrue(driver.getCurrentUrl().startsWith(peopleWithJobs.getPageUrl()));
    }

    @When("^I click Edit$")
    public void iClickEdit() throws Throwable {
        peopleWithJobs.clickEditButton();
    }

    @Then("^I see editing page$")
    public void iSeeEditingPage() throws Throwable {
        assertEquals(driver.getCurrentUrl(), editPersonPage.getPageUrl());
    }

    @And("^I editing name and job$")
    public void iEditingNameAndJob(Map<String, String> values) throws Throwable {
        editPersonPage.iEditNameAndJob(values);
    }

    @And("^I click Edit button$")
    public void iClickEditButton() throws Throwable {
        editPersonPage.clickEditButton();
    }

    @And("^person is changed$")
    public void personIsChanged() throws Throwable {
        assertEquals("Valentina, Test Engineer", (editPersonPage.editPersonText()));
    }

    @When("^I click remove first person$")
    public void iClickRemovePerson() throws Throwable {
        peopleWithJobs.clickDeleteButton();
    }

    @Then("^First person is removed$")
    public void personIsRemoved() throws Throwable {
        assertTrue(firstPersonsListSize > peopleWithJobs.personListSize());
    }

    @And("^I click Reset list button$")
    public void iClickResetListButton() throws Throwable {
        peopleWithJobs.clickResetListButton();
    }

    @And("^I click clear all fields button$")
    public void iClickClearAllFieldsButton() throws Throwable {
        newPersonPage.clickClearAllFieldsButton();
    }

    @Then("^I see all fields are cleared$")
    public void iSeeAllFieldsAreCleared() throws Throwable {
        newPersonPage.clearedFields();
    }

    @Then("^I see original person list$")
    public void iSeeOriginalListSize() throws Throwable {
        assertTrue(firstPersonsListSize == peopleWithJobs.personListSize());
    }
}
