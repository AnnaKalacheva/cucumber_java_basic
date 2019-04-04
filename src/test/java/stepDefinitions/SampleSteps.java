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

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @When("^I enter name2: (.*)$")
    public void iEnterName2(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$") //i am on page or i open page, "?" makes the last simbol before "?" optional
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"([^\"]*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
            System.out.println("key is " + e.getKey());
            System.out.println("value is " + e.getValue());
        }
    }

    @And("^I should see menu$") // throws Throwable
    public void iShouldSeeMenu() {
        assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
    }

    @And("^I click the result checkbox button$")
    public void iClickTheResultCheckboxButton() throws Throwable {
        driver.findElement(By.id("result_button_checkbox")).click();
    }

    @When("^I clicked on checkboxes:$")
    public void iClickedOnCheckboxes(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.cssSelector("[value='" + value + "']")).click();
        }
    }

    @Then("^message for checkboxes \"([^\"]*)\" is seen$")
    public void messageForCheckboxesIsSeen(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("result_checkbox")).getText());
    }

    @Given("^I am on action page$")
    public void iAmOnActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @And("^I should see some text$")
    public void iShouldSeeSomeText() {
        assertTrue(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("p")).getText());
    }

    @When("^I open styles page$")
    public void iOpenStylesPage() {
        driver.get("https://kristinek.github.io/site/examples/styles");
    }

    @Then("^I should see styles page header$")
    public void iShouldSeeStylesPageHeader() {
        assertEquals("Lorem ipsum", driver.findElement(By.tagName("h1")).getText());
    }

    @When("^I open action page$")
    public void iOpenActionPage() {
       driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @And("^I enter number: (\\d+)$")
    public void iEnterNumber(int number) throws Throwable {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(String.valueOf(number));
    }

    @And("^I click Result$")
    public void iClickEnter() {
        driver.findElement(By.id("result_button_number")).click();
    }

//   \"(.*)\"$") - to write input with quotes
    @Then("^I see Text: (.*)$")
    public void iSeeText(String text) throws Throwable {
       assertEquals(text, driver.findElement(By.id("result_number")).getText());
    }

    @Given("^I (?:am on|open) number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter a number: (.*)$")
    public void iEnterANumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
    }

    @And("^I click on Submit$")
    public void iClickOnSubmit() {
        driver.findElement(By.className("w3-btn")).click();
    }

    @Then("^I see result message: (.*)$")
    public void iSeeResultMessage(String message) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(message, alert.getText());
    }

    @Then("^I click OK on result message$")
    public void iClickOKOnResultMessage(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Then("^I see error message: (.*)$")
    public void iSeeErrorMessage(String text) throws Throwable {
        assertEquals(text, driver.findElement(By.id("ch1_error")).getText());
    }
}
