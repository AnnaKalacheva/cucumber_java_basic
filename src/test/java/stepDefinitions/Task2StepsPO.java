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
import org.openqa.selenium.support.ui.Select;
import pages_sample.AgePage;
import pages_sample.AgeSubmittedPage;
import pages_task.FirstPage;
import pages_task.SecondPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Task2StepsPO {


    private WebDriver driver;
    static pages_task.FirstPage firstPage;
    static SecondPage secondPage;

    public Task2StepsPO() {
        this.driver = Hooks.driver;
        firstPage = PageFactory.initElements(Hooks.driver, FirstPage.class);
        secondPage = PageFactory.initElements(Hooks.driver, SecondPage.class);
    }


    @Given("^Entering People with jobs$")
    public void enteringPeopleWithJobs() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }


    @When("^add new person$")
    public void addNewPerson() throws Throwable {
        firstPage.list();
        firstPage.addPersonBtn();

    }


    @And("^add person$")
    public void addPerson() throws Throwable {
        secondPage.add();
        firstPage.list2();
    }


    @When("^edit person$")
    public void editPerson() throws Throwable {
        firstPage.list();
        firstPage.edit();
    }

    @When("^delete person$")
    public void deletePerson() throws Throwable {
        firstPage.list();
        firstPage.delete();

    }

    @When("^reset list$")
    public void resetList() throws Throwable {
        firstPage.list();
        firstPage.resetButton();


    }

    @Then("^add edited person$")
    public void addEditedPerson() throws Throwable {
        secondPage.edit();
    }

    @And("^clear fields$")
    public void clearFields() throws Throwable {
        secondPage.clear();
    }

    @Then("^check empty fields$")
    public void checkEmptyFields() throws Throwable {
        secondPage.checkFields();
    }


    @And("^enter fields info \"([^\"]*)\"\"([^\"]*)\"$")
    public void enterFieldsInfo(String name, String surname) throws Throwable {
        secondPage.name(name, surname);
    }

    @And("^enter fields \"([^\"]*)\"\"([^\"]*)\"$")
    public void enterFields(String job, String date) throws Throwable {
        secondPage.job(job, date);
    }

    @And("^enter fields \"([^\"]*)\"\"([^\"]*)\"\"([^\"]*)\"$")
    public void enterFields(List<String> languages, String gender, String employee) throws Throwable {
        secondPage.languages(languages, gender, employee);
    }

    @Then("^check that person was add$")
    public void checkThatPersonWasAdd() throws Throwable {
        firstPage.addPersonCheck();

    }

    @Then("^check that person was delete$")
    public void checkThatPersonWasDelete() throws Throwable {
        firstPage.deletePersonCheck();
    }
}
