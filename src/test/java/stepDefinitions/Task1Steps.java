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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I open enter a number page$")
    public void iOpenEnterANumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter invalid input (.*) in the number field$")
    public void iEnterInvalidInputInputInTheNumberField(String input) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(input);
    }

    @And("^I click on submit button$")
    public void iClickOnSubmitButton() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn.w3-orange.w3-margin")).click();
    }

    @Then("^I see error message (.*)$")
    public void iSeeErrorMessageInput(String input) throws Throwable {
        try {
            int num = Integer.parseInt(input);
            if(num < 50) {
                assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
            } else if (num > 100) {
                assertEquals("Number is too big", driver.findElement(By.id("ch1_error")).getText());
            }
        } catch (NumberFormatException e) {
            assertEquals("Please enter a number", driver.findElement(By.id("ch1_error")).getText());
        }
    }

    @When("^I enter (\\d+) in the number field$")
    public void iEnterInTheNumberField(int num) throws Throwable {
        String text = Integer.toString(num);
        driver.findElement(By.id("numb")).sendKeys(text);
    }

    @Then("^I see a message: \"([^\"]*)\"$")
    public void iSeeAMessage(String message) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
    }
}
