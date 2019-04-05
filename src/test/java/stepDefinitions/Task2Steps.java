package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;


public class Task2Steps {
    private WebDriver driver;

    public Task2Steps() {
        this.driver = Hooks.driver;
        jobPage = PageFactory.initElements(Hooks.driver, JobPage.class);
        jobPage2 = PageFactory.initElements(Hooks.driver, JobPage2.class);
    }

    static JobPage jobPage;
    static JobPage2 jobPage2;

    @Given("^I am on job page$")
    public void iAmOnJobPage() throws Throwable {

        driver.get(jobPage.getPageUrl());
    }

    @When("^I click add a person$")
    public void iClickAddAPerson() throws Throwable {

        jobPage.clickAddPersonButton();

    }

    @And("^I enter person name: \"([^\"]*)\"$")
    public void iEnterPersonName(String personName) throws Throwable {

        jobPage.enterPersonName(personName);
    }

    @And("^I enter job title: \"([^\"]*)\"$")
    public void iEnterJobTitle(String jobTitle) throws Throwable {

        jobPage.enterJobTitle(jobTitle);
    }

    @And("^I click add button$")
    public void iClickAddButton() throws Throwable {

        jobPage2.clickAddButton();
    }

    @Then("^I see person's (.*) and job's (.*) name$")
    public void iSeePersonSNameAndJobSTitleName(String name, String title) throws Throwable {

        jobPage.checkPersonAddedName(name);
        jobPage.checkPersonAddedJobTitle(title);

    }


    @When("^I click edit person$")
    public void iClickEditPerson() throws Throwable {
        jobPage.clickEditPerson();
    }

    @And("^I edit person name: \"([^\"]*)\"$")
    public void iEditPersonName(String name) throws Throwable {
        jobPage.editName(name);
    }

    @And("^I edit job title: \"([^\"]*)\"$")
    public void iEditJobTitle(String jobTitle) throws Throwable {
        jobPage.editJobTitle(jobTitle);
    }

    @And("^I click edit button$")
    public void iClickEditButton() throws Throwable {
        jobPage2.pressEditAfterChanger();
    }

    @Then("^I see person's edit: \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iSeePersonSEditNameAndTitle(String name, String title) throws Throwable {
        jobPage2.checkEditChangesForName(name);
        jobPage2.checkEditChangesForJob(title);
    }

    @When("^I click remove icon$")
    public void iClickRemoveIcon() throws Throwable {
        jobPage.removePerson();
    }

    @And("^I see person is removed$")
    public void iSeePersonIsRemoved() throws Throwable {
        jobPage.checkPersonRemoved();
    }

    @Then("^I reset original list$")
    public void iResetOriginalList() throws Throwable {
        jobPage.pressResetButton();
    }

    @Then("^I check that list is reset$")
    public void iCheckThatListIsReset() throws Throwable {
     jobPage.checkListIsOriginalAfterReset();
    }

    @Then("^I see input fields empty$")
    public void iSeeInputFieldsEmpty() throws Throwable {
        jobPage.checkButtonClearWorks();
    }

    @And("^I clear all input fields$")
    public void iClearAllInputFields() throws Throwable {
        jobPage.clearAllInputFields();
    }
}
