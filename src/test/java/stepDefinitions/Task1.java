package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.NumberPage;

public class Task1 {
    private WebDriver driver;
    private NumberPage numberPage;

    public Task1(){
        this.driver = Hooks.driver;
        numberPage = PageFactory.initElements(Hooks.driver, NumberPage.class);
    }

    @Given("^I open Enter a number page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number: ([^\"]*)$")
    public void iEnterNumberNumber(String number) throws Throwable {
        numberPage.enterNumber(number);
    }

    @And("^I click Submit$")
    public void iClickSubmit() throws Throwable {
        numberPage.clickSubmit();
    }

    @Then("^I see an error message: \"([^\"]*)\"$")
    public void iSeeAnErrorMessageMessage(String message) throws Throwable {
        numberPage.checkErrorMessage(message);
    }

    @Then("^I get an alert with message: \"([^\"]*)\"$")
    public void iGetAnAlertWithMessage(String message) throws Throwable {
        numberPage.checkAnswer(message, driver.switchTo().alert());
    }

    @And("^I press OK$")
    public void iPressOK() throws Throwable {
        numberPage.clickAlertOK(driver.switchTo().alert());
    }
}
