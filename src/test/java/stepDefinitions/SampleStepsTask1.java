package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class SampleStepsTask1 {
    private WebDriver driver;

    public SampleStepsTask1() {
        this.driver = Hooks.driver;
    }



    @Given("^I am on Enter a number page$")
    public void iAmOnTheNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @Then("^I enter ([^\"]*)$")
    public void iEnterNumber(String number) throws Throwable {

        driver.findElement(By.cssSelector("#numb")).sendKeys(number);

    }

    @And("^I click submit$")
    public void iClickSubmit() {
        driver.findElement(By.xpath("//button[@class='w3-btn w3-orange w3-margin']")).click();

    }

    @Then("^Then I see message: \"([^\"]*)\"$")
    public void thenISeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.cssSelector("#ch1_error")).getText());
    }


    @Then("^I see message answer : \"([^\"]*)\"$")
    public void iSeeMessageAnswer(String answer) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(answer, alert.getText());

    }
}