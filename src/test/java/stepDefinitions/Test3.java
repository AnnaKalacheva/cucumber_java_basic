package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import pages_sample.*;

public class Test3 {
    private WebDriver driver;

    public Test3() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the age page$")
    public void iAmOnTheAgePage() {
        driver.get("https://kristinek.github.io/site/examples/age.html");
    }

    @When("^I enter age: \"([^\"]*)\"$")
    public void iEnterAge(String age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Then("^I click on the submit button$")
    public void iClickOnTheSubmitButton() {
        driver.findElement(By.xpath("//button[@onclick='showNameAndAge()']")).click();

    }

    @Then("^I can see the message \"([^\"]*)\"$")
    public void iCanSeeTheMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("error")).getText());
    }

    // ================= Scenario2 =====================

    @When("^I fill the name field: \"([^\"]*)\"$")
    public void iFillTheNameField(String name) throws Throwable {
        driver.findElement(By.id("name")).sendKeys(String.valueOf(name));
    }

    // ================= Scenario3 =======================


    @Then("^I can see message \"([^\"]*)\"$")
    public void iCanSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());

    }

    // ================= Scenario4 =============
    @Then("^I click on the back button$")
    public void iClickOnTheBackButton() {
        driver.findElement(By.xpath("//button[@class='w3-btn w3-white w3-border w3-margin-top']")).click();
    }

    @Then("^I returned to the age page$")
    public void iReturnedToTheAgePage() {
        driver.findElement(By.id("name"));
        driver.findElement(By.id("age"));
    }
}
