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

import static org.junit.Assert.*;

public class Task2Steps {
    private WebDriver driver;

    public Task2Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on people with jobs page$")
    public void iAmOnPeopleWithJobsPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs ");
    }


    @When("^I click on add person button$")
    public void iClickOnAddPersonButton() throws Throwable {
        driver.findElement(By.xpath("//div[4]//button[1]")).click();
    }

    @And("^I enter name: (.+), and job: (.+)$")
    public void iEnterNameNameAndJobJob(String name, String job) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);

        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click on add button$")
    public void iClickOnAddButton() throws Throwable {
        driver.findElement(By.cssSelector("#modal_button:nth-of-type(1)")).click();
    }

    @Then("^I see a new person (.+) with job (.+)$")
    public void iSeeANewPersonWithJob(String name, String job) throws Throwable {
        int size = driver.findElements(By.id("person3")).size();
        assertEquals(1, size);

        assertEquals(name, driver.findElement(By.cssSelector("#person3 .name")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person3 .job")).getText());

    }

    @When("^I click on first edit icon$")
    public void iClickOnFirstEditIcon() throws Throwable {
        driver.findElement(By.xpath("//span[@onclick='openModalForEditPersonWithJob(0)']")).click();
    }

    @And("^I change name to \"(.+)\" and job to \"(.+)\"$")
    public void iChangeNameToAndJobTo(String name, String job) throws Throwable {
        driver.findElement(By.cssSelector("#name")).clear();
        driver.findElement(By.cssSelector("#name")).sendKeys(name);

        driver.findElement(By.cssSelector("#job")).clear();
        driver.findElement(By.cssSelector("#job")).sendKeys(job);
    }

    @And("^I click on edit button$")
    public void iClickOnEditButton() throws Throwable {
        driver.findElement(By.xpath("//button[@onclick='editPersonWithJob(0)']")).click();
    }

    @Then("^I see first person with name \"(.+)\" and job \"(.+)\"$")
    public void iSeeFirstPersonWithNameAndJob(String name, String job) throws Throwable {
        assertEquals(name, driver.findElement(By.cssSelector("#person0 .name")).getText());
        assertEquals(job, driver.findElement(By.cssSelector("#person0 .job")).getText());
    }

    @When("^I click on remove person icon (.+)$")
    public void iClickOnRemovePersonIconPerson(String person) throws Throwable {
        driver.findElement(By.cssSelector("#" + person + " span:nth-of-type(1)")).click();
    }

    @Then("^I don't see removed person (.+)$")
    public void iDonTSeeRemovedPersonPerson(String person) throws Throwable {
        int size = driver.findElements(By.id(person)).size();
        assertEquals(0, size);
    }

    @And("^I click on reset list button$")
    public void iClickOnResetListButton() throws Throwable {
        driver.findElement(By.xpath("//div[4]//button[2]")).click();

        int size = driver.findElements(By.id("person0")).size();
        assertEquals(1, size);
        assertEquals("Mike", driver.findElement(By.cssSelector("#person0 .name")).getText());
        assertEquals("Web Designer" , driver.findElement(By.cssSelector("#person0 .job")).getText());

        size = driver.findElements(By.id("person1")).size();
        assertEquals(1, size);
        assertEquals("Jill", driver.findElement(By.cssSelector("#person1 .name")).getText());
        assertEquals("Support" , driver.findElement(By.cssSelector("#person1 .job")).getText());

        size = driver.findElements(By.id("person2")).size();
        assertEquals(1, size);
        assertEquals("Jane", driver.findElement(By.cssSelector("#person2 .name")).getText());
        assertEquals("Accountant" , driver.findElement(By.cssSelector("#person2 .job")).getText());
    }

    @And("^I click on clear all fields button$")
    public void iClickOnClearAllFieldsButton() throws Throwable {
        driver.findElement(By.xpath("//button[contains(text(), 'Clear all fields')]")).click();
    }

    @Then("^I see that all fields are clear$")
    public void iSeeThatAllFieldsAreClear() throws Throwable {
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());
    }
}
