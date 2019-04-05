package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.Task2ListPage;
import pages_sample.Task2ProfilePage;

import java.util.List;

public class Task2StepsWithPO {

    private WebDriver driver;
    static Task2ListPage listPage;
    static Task2ProfilePage profilePage;


    public Task2StepsWithPO() {
        this.driver = Hooks.driver;
        listPage = PageFactory.initElements(Hooks.driver, Task2ListPage.class);
        profilePage = PageFactory.initElements(Hooks.driver, Task2ProfilePage.class);
    }

    @Given("^I am on ListPage$")
    public void iAmOnListPage() {
        driver.get(listPage.getListPageUrl());
    }

    @When("^I click Add person button$")
    public void iPressAddPersonButton() {
        listPage.clickAddPersonBtn();
    }

    @Then("^I click Add button$")
    public void iClickAddButton() throws InterruptedException {
        Thread.sleep(5000);
        profilePage.addToList();
        Thread.sleep(5000);
    }

    @When("^I click edit person button$")
    public void iClickEditPersonButton() {
        listPage.editPersonBtn();
    }

    @Then("^I click Edit button$")
    public void iClickEditButton() {
        profilePage.editBtnToSave();
    }

    @Then("^I click remove person button$")
    public void iClickRemovePersonButton() {
        listPage.removePerson();
    }

    @Then("^I click reset button$")
    public void iClickResetButton() {
        listPage.resetBtn();
    }

    @And("^I click clear fields button$")
    public void iClickClearFieldsButton() {
        profilePage.clearAllBtn();
    }

    @Then("^I check fields cleared$")
    public void iCheckFieldsCleared() {
        profilePage.checkAllCleared();
    }

    @And("^I enter user information: \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterUserInformation(String jobTitle, List<String> languages, String status) {
        profilePage.enterUserInformation(jobTitle, status);
    }

    @And("^I enter user data: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterUserData(String name, String surname){
        profilePage.enterUserName(name, surname);
    }

    @And("^I enter date of birth: \"([^\"]*)\"$")
    public void iEnterDateOfBirth(String dateOfBirth) {
        profilePage.enterDateOfBirth(dateOfBirth);
    }

    @And("^I enter user gender: \"([^\"]*)\"$")
    public void iEnterUserGender(String gender) {
        profilePage.enterGender(gender);
    }

    @And("^I enter user information: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iEnterUserInformation(String jobTitle, String status) {
        profilePage.enterUserInformation(jobTitle, status);
    }

    @And("^I enter languages: \"([^\"]*)\"$")
    public void iEnterLanguages(List<String> languages) {
        profilePage.chooseLanguages(languages);
    }


    @Then("^I check if person added$")
    public void iCheckIfPersonAdded() {
        listPage.checkAdded();
    }

    @Then("^I check if person removed$")
    public void iCheckIfPersonRemoved() {
        listPage.checkRemoved();
    }

    @Then("^I check person name changed to: \"([^\"]*)\" \"([^\"]*)\"$")
    public void iCheckPersonNameChangedTo(String name, String surname) {
        listPage.checkEdited(name, surname);

    }

    @Then("^I check person \"([^\"]*)\" \"([^\"]*)\" removed$")
    public void iCheckPersonRemoved(String name, String surname) {
        listPage.checkDeleted(name, surname);
    }
}
