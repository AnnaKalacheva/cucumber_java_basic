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

public class PeopleWithJobsSteps {

    private WebDriver driver;
    static PeopleWithJobsPage peopleWithJobsPage;
    static AddPersonPage addPersonPage;
    static EditPersonPage editPersonPage;

    public PeopleWithJobsSteps() {
        this.driver = Hooks.driver;
        peopleWithJobsPage = PageFactory.initElements(Hooks.driver, PeopleWithJobsPage.class);
        addPersonPage = PageFactory.initElements(Hooks.driver, AddPersonPage.class);
        editPersonPage = PageFactory.initElements(Hooks.driver, EditPersonPage.class);
    }

    @Given("^I am on people with jobs page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get(peopleWithJobsPage.getPageUrl());
    }


    @When("^I click on add new person button$")
    public void iClickOnAddNewPersonButton() throws Throwable {
        peopleWithJobsPage.clickAddPerson();
    }


    @And("^I enter persons values:$")
    public void iEnterPersonsValues(Map<String, String> valuesToEnter) throws Throwable {
      addPersonPage.enterName(valuesToEnter.get("name"));
      addPersonPage.enterJob(valuesToEnter.get("job"));
    }

    @And("^I click on Add$")
    public void iClickOnAdd() throws Throwable {
        addPersonPage.clickAdd();
    }

    @Then("^I see new person in list$")
    public void iSeeNewPersonInList(Map<String, String> valuesToEnter) throws Throwable {
        peopleWithJobsPage.checkAddedPersonsName(valuesToEnter.get("name"));
        peopleWithJobsPage.checkAddedPersonsJob(valuesToEnter.get("job"));

    }

    @When("^I click on edit person button$")
    public void iClickOnEditPersonButton() throws Throwable {
        peopleWithJobsPage.clickEditPerson0();
    }

    @And("^I change persons values$")
    public void iChangePersonsValues(Map<String, String> valuesToEnter) throws Throwable {
        editPersonPage.editName(valuesToEnter.get("name"));
        editPersonPage.editJob(valuesToEnter.get("job"));
    }

    @And("^click on Edit button$")
    public void clickOnEditButton() throws Throwable {
        editPersonPage.clickEdit();
    }

    @Then("^I see edited values in list$")
    public void iSeeEditedValuesInList(Map<String, String> valuesToEnter) throws Throwable {
        peopleWithJobsPage.checkEditedPersonsName(valuesToEnter.get("name"));
        peopleWithJobsPage.checkEditedPersonsJob(valuesToEnter.get("job"));
    }


    @Then("^I see that person is removed from the list$")
    public void personIsRemovedFromTheList() throws Throwable {
        peopleWithJobsPage.checkpersonRemovedFromList();
    }

    @Then("^I click on Reset button$")
    public void iClickOnResetButton() throws Throwable {
        peopleWithJobsPage.clickResetListButton();
    }

    @Then("^I see original list$")
    public void iSeeOriginalList() throws Throwable {
        peopleWithJobsPage.checkOriginalListValues();
    }

    @When("^I click on Remove button for person with index:  (\\d+)$")
    public void iRemovePersonWithIndex(int index) throws Throwable {
        peopleWithJobsPage.clickonremove(index);

    }


    @And("^I click on Clear All")
    public void iClickOnCancel() throws Throwable {
        addPersonPage.clickClearAll();
    }

    @Then("^I see no text in input fields$")
    public void iSeeNoTextInInputFields() throws Throwable {
        addPersonPage.checkFormIsClean();
    }

    @Then("^I see that the person is removed$")
    public void iSeeThatThePersonIsRemoved() throws Throwable {
        peopleWithJobsPage.checkpersonRemovedFromList();
    }


}
