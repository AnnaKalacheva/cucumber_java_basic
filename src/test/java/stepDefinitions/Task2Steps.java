package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task2Steps {
    private WebDriver driver;
    static PeopleWithJobsPage peopleWithJobsPage;
    static EditPersonPage editPersonPage;
    static AddNewPersonPage addNewPersonPage;

    public Task2Steps() {
        this.driver = Hooks.driver;
        peopleWithJobsPage = PageFactory.initElements(Hooks.driver, PeopleWithJobsPage.class);
        editPersonPage = PageFactory.initElements(Hooks.driver, EditPersonPage.class);
        addNewPersonPage = PageFactory.initElements(Hooks.driver, AddNewPersonPage.class);
    }

    @Given("^I am on enter a people with job page$")
    public void iAmOnEnterpeoplewithjobsPage() throws Throwable {

        driver.get(peopleWithJobsPage.getPageUrl());
    }


    @When("^I click on add new person$")
    public void iClickOnAddNewPerson() throws Throwable {
        peopleWithJobsPage.clickAddPersonButtton();

    }

    @Then("^I see add new person page$")
    public void iSeeAddNewPersonPage() throws Throwable {

    }

    @And("^I enter people name: \"([^\"]*)\"$")
    public void iEnterPeopleName(String names) throws Throwable {
        addNewPersonPage.entername(names);
    }

    @And("^I enter people job: \"([^\"]*)\"$")
    public void iEnterPeopleJob(String jobs) throws Throwable {
        addNewPersonPage.enterjob(jobs);
    }

    @And("^I click add button$")
    public void iClickAddButton() throws Throwable {
        addNewPersonPage.clickAddButton();
    }

    @When("^I click on edit person$")
    public void iClickOnEditPerson() throws Throwable {
        peopleWithJobsPage.clickEditIcon();
    }

    @Then("^I see edit person page$")
    public void iSeeEditPersonPage() throws Throwable {

    }

    @And("^I click on edit button$")
    public void iClickOnEditButton() throws Throwable {
        editPersonPage.clickEditButton();

    }

    @Then("^I see edited names and job: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iSeeEditedNamesAndJob(String names, String jobs) throws Throwable {
        peopleWithJobsPage.checkname(names);
        peopleWithJobsPage.checkjob(jobs);

    }

    @When("^I click on delete person$")
    public void iClickOnDeletePerson() throws Throwable {
        peopleWithJobsPage.clickDeleteIcon();
    }

    @Then("^I see person is removed from list$")
    public void iSeePersonIsRemovedFromList() throws Throwable {
        peopleWithJobsPage.checkListRemoved();
    }

    @And("^I click on reset list$")
    public void iClickOnResetList() throws Throwable {
        peopleWithJobsPage.clickResetListButtton();
    }

    @Then("^I see list names and job title reset: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iSeeListNamesAndJobTitleReset(String defaultnames, String defaultjobs) throws Throwable {
        peopleWithJobsPage.checkname(defaultnames);
        peopleWithJobsPage.checkjob(defaultjobs);
    }

    @And("^I edit people name: \"([^\"]*)\"$")
    public void iEditPeopleName(String names) throws Throwable {
        editPersonPage.editName(names);

    }

    @And("^I edit people job: \"([^\"]*)\"$")
    public void iEditPeopleJob(String jobs) throws Throwable {
        editPersonPage.editJob(jobs);
    }

    @Then("^I click on clear all fields$")
    public void iClickOnClearAllFields() throws Throwable {
        addNewPersonPage.clickclearAllFieldsButton();
    }

    @Then("^I see person is removed from list after added$")
    public void iSeePersonIsRemovedFromListAfterAdded() throws Throwable {
       peopleWithJobsPage.checkListRemovedafteradded();
    }
}
