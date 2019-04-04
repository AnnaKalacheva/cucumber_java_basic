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
import static org.junit.Assert.assertTrue;

public class Task1Steps {
    private WebDriver driver;

    public Task1Steps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on enter a number page$")
    public void iAmOnEnterANumberPage() throws Throwable {

        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: (\\d+)$")
    public void iEnterNumberNumber(int number) throws Throwable {

        WebElement num = driver.findElement(By.id("numb"));
        num.sendKeys(String.valueOf(number));
    }

    @And("^I click submit number$")
    public void iClickSubmitNumber() throws Throwable {
       driver.findElement(By.xpath("//*[@class=\"w3-btn w3-orange w3-margin\"]")).click();
    }

    @Then("^I see error text: \"([^\"]*)\"$")
    public void iSeeErrorText(String error) throws Throwable {
      WebElement text = driver.findElement(By.id("ch1_error"));
      assertEquals(error,text.getText());
    }

    @When("^I enter text: (.*)$")
    public void iEnterNumberText(String text) throws Throwable {
        WebElement num = driver.findElement(By.id("numb"));
        num.sendKeys(text);

    }


    @Then("^I see result in alert message: \"([^\"]*)\"$")
    public void iSeeTextInAlert(String alerttext) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(alerttext,alert.getText());
    }
}
