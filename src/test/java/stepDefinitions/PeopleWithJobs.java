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

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class PeopleWithJobs {
    private WebDriver driver;

    public PeopleWithJobs() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on People with jobs page$")
    public void iAmOnPeopleWithJobsPage() {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");
    }

    @When("^I click on Add person button$")
    public void iClickOnAddPersonButton() throws Throwable {
        driver.findElement(By.id("addPersonBtn")).click();
    }

    @And("^I enter person name: \"([^\"]*)\"$")
    public void iEnterPersonName(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter job: \"([^\"]*)\"$")
    public void iEnterJob(String job) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);

    }

    @Then("^I click on Add button$")
    public void iClickOnAddButton() {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^check that person with \"([^\"]*)\" and \"([^\"]*)\" is exists$")
    public void checkThatPersonWithAndIsExists(String name, String job) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(name, driver.findElement(By.xpath("//span[text()='" + name + "']")).getText());
        assertEquals(job, driver.findElement(By.xpath("//span[text()='" + job + "']")).getText());
    }

    //========= Edit person ==========

    @When("^I click on edit person button$")
    public void iClickOnEditPersonButton() {
        driver.findElement(By.xpath("//span[@onclick='openModalForEditPersonWithJob(0)']")).click();
    }


    @And("^I can edit name: \"([^\"]*)\"$")
    public void iCanEditName(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I can edit job: \"([^\"]*)\"$")
    public void iCanEditJob(String job) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @Then("^I click on save changes$")
    public void iClickOnSaveChanges() {
        driver.findElement(By.id("modal_button")).click();
    }

    @Then("^check that person \"([^\"]*)\" is exists$")
    public void checkThatPersonIsExists(String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(name, driver.findElement(By.xpath("//span[text()='" + name + "']")).getText());
    }

    //========= Remove person ==========

    @When("^I click on remove person button with \"([^\"]*)\"$")
    public void iClickOnRemovePersonButtonWith(String id) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//span[@onclick='deletePerson(" + id + ")']")).click();
    }

    @Then("^I can see that person with \"([^\"]*)\"disappeared$")
    public void iCanSeeThatPersonWithDisappeared(String id) {
        // Write code here that turns the phrase above into concrete actions
        try {
            driver.findElement(By.id("person" + id));
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Unable to locate element"));
        }
    }
    //========= Reset person ==========

    @Then("^I click on reset list button$")
    public void iClickOnResetListButton() {
        driver.findElement(By.xpath("//button[@onclick='resetListOfPeople()']")).click();
    }
}

