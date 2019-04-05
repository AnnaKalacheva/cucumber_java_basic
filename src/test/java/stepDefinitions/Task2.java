package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task2 {
    private WebDriver driver;
    private ListPage listPage;
    private FormPage formPage;
    private ArrayList<LinkedHashMap<String, String>> listBeforeChange;

    public Task2() {
        this.driver = Hooks.driver;
        listPage = PageFactory.initElements(driver, ListPage.class);
        formPage = PageFactory.initElements(driver, FormPage.class);
    }

    @Given("^I open List of people page$")
    public void iOpenListOfPeoplePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }

    @When("^I remember current list of people$")
    public void iRememberCurrentListOfPeople() throws Throwable {
        listBeforeChange = listPage.getList();
    }

    @And("^I click on Add person button$")
    public void iClickOnAddPersonButton() throws Throwable {
        listPage.clickAddPersonBtn();
    }

    @And("^I click Edit button for a person at: (\\d+)$")
    public void iClickEditButtonForAPersonAtPlace(int index) throws Throwable {
        listPage.clickEditButton(index);
    }

    @And("^I click Delete button for a person at: (\\d+)$")
    public void iClickDeleteButtonForAPersonAtPlace(int index) throws Throwable {
        listPage.clickDeleteButton(index);
    }

    @And("^I click Reset List button$")
    public void iClickResetListButton() throws Throwable {
        listPage.clickResetBtn();
    }

    @And("^I enter values for the person:$")
    public void iEnterValuesForThePerson(Map<String, String> values) throws Throwable {
        values.forEach((k, v) -> formPage.enterInput(k, v));
    }

    @And("^I select languages: ([^\"]*)$")
    public void iSelectLanguagesLanguages(String languages) throws Throwable {
        formPage.selectLanguages(languages);
    }

    @And("^I select a gender: ([^\"]*)$")
    public void iSelectAGenderGender(String gender) throws Throwable {
        formPage.selectGender(gender);
    }

    @And("^I select an employee status: ([^\"]*)$")
    public void iSelectAnEmployeeStatusStatus(String status) throws Throwable {
        formPage.selectEmployeeStatus(status);
    }

    @And("^I click Add button$")
    public void iClickAddButton() throws Throwable {
        formPage.clickAddBtn();
    }

    @And("^I click Edit button$")
    public void iClickEditButton() throws Throwable {
        formPage.clickEditBtn();
    }

    @And("^I click Clear all fields button$")
    public void iClickClearAllFieldsButton() throws Throwable {
        formPage.clickClearBtn();
    }

    @Then("^I see a new person with:$")
    public void iSeeANewPersonWith(Map<String, String> values) throws Throwable {
        values.forEach((k, v) -> listPage.checkFieldOfLastPerson(k, v));
    }

    @Then("^I see the values for a person at: (\\d+)$")
    public void iSeeTheValuesForAPersonAtPlace(int index, Map<String, String> values) throws Throwable {
        values.forEach((k, v) -> listPage.checkField(k, v, index));
    }

    @And("^I see that other people did not change after add$")
    public void iSeeThatOtherPeopleDidNotChangeAfterAdd() throws Throwable {
        listPage.checkNoChangeAfterAdd(listBeforeChange);
    }

    @And("^I see that other people did not change after editing a person at: (\\d+)$")
    public void iSeeThatOtherPeopleDidNotChangeAfterEditingAPersonAtPlace(int index) throws Throwable {
        listPage.checkNoChangeAfterEdit(listBeforeChange, index);
    }

    @Then("^I see that a person at (\\d+) was deleted and others did not change$")
    public void iSeeThatAPersonAtPlaceWasDeletedAndOthersDidNotChange(int index) throws Throwable {
        listPage.checkNoChangeAfterDelete(listBeforeChange, index);
    }

    @Then("^I see the original list$")
    public void iSeeTheOriginalList() throws Throwable {
        listPage.checkNoChange(listBeforeChange);
    }

    @Then("^I see that all of the fields are cleared$")
    public void iSeeThatAllOfTheFieldsAreCleared() throws Throwable {
        final String[] names = {"name", "surname", "job", "birthDate", "languages", "gender", "status"};
        final String[] values = {"", "", "", "", "English", "", "Employee"};
        for (int i = 0; i < names.length; i++) {
            formPage.checkInput(names[i], values[i]);
        }
    }
}