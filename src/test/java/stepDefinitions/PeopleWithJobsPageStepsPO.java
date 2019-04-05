package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.Map;

public class PeopleWithJobsPageStepsPO {

    private WebDriver driver;
    static PeopleWithJobsPage peopleWithJobsPage;
    //static PeopleWithJobsAddingPage peopleWithJobsAddingPage;

    public PeopleWithJobsPageStepsPO() {
        this.driver = Hooks.driver;
        peopleWithJobsPage = PageFactory.initElements(Hooks.driver, PeopleWithJobsPage.class);
        //peopleWithJobsAddingPage = PageFactory.initElements(Hooks.driver, PeopleWithJobsAddingPage.class);
    }

    @Given("^I am on People with Jobs page$")
    public void iAmOnPeopleWithJobsPage() {
        driver.get(peopleWithJobsPage.getPageUrl());
    }

    @When("^I click Add person button$")
    public void iClickAddPersonButton() {
        peopleWithJobsPage.clickAddPersonButton();
    }

    @Then("^I am on People with Jobs page and I see new line in list of people is added$")
    public void iAmOnPeopleWithJobsPageAndISeeNewLineInListOfPeopleIsAdded() {
        peopleWithJobsPage.checkNewLine();
    }

    @When("^I click Edit button$")
    public void iClickEditButton() {
        peopleWithJobsPage.clickEditButtonFirstPerson();
    }

    @Then("^I am on People with Jobs page I see person info is edited$")
    public void iAmOnPeopleWithJobsPageISeePersonInfoIsEdited() throws Throwable {
        peopleWithJobsPage.checkFirstPersonInfoEdited();
    }

    @When("^I click delete Person button$")
    public void iClickDeletePersonButton() throws Throwable {
        peopleWithJobsPage.ClickDeletePersonButton();
    }

    @Then("^I see person is removed$")
    public void iSeePersonIsRemoved() throws Throwable {
        peopleWithJobsPage.isPersonIsRemoved();
    }

    @Then("^I click Reset button and I see original list$")
    public void iClickResetButtonAndISeeOriginalList() throws Throwable {
        peopleWithJobsPage.clickResetButton();
    }
}
