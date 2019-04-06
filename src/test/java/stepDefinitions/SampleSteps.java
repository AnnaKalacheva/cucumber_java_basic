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
        this.driver = stepDefinitions.Hooks.driver;
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

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
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

    @And("^I should see menu$")
    public void iShouldSeeMenu() throws Throwable {
        Thread.sleep(1000);
        assertTrue(driver.findElement(By.cssSelector(".w3-navbar")).isDisplayed());
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
    public void iShouldSeeSomeText() throws Throwable {
        assertTrue(driver.findElement(By.tagName("p")).isDisplayed());
        // Write code here that turns the phrase above into concrete actions
        System.out.println(driver.findElement(By.tagName("p")).getText());
    }

    @Given("^I open styles page$")
    public void OpenStylesPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/styles");
    }

    @Then("^correct header is seen$")
    public void correctHeaderIsSeen() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String actualText = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Lorem ipsum", actualText);
    }

    @Given("^I open action page$")
    public void iOpenActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }
    // Write code here that turns the phrase above into concrete actions


    @And("^I enter number (\\d+) in number field$")
    public void iEnterNumberInNumberField(int arg0) throws Throwable {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys("5");
        // Write code here that turns the phrase above into concrete actions

    }

    @And("^I click Result$")
    public void iClickResult() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("result_button_number")).click();

    }

    @Then("^I see text: \"([^\"]*)\"(\\d+)\"([^\"]*)\"$")
    public void iSeeText(String arg0, int arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("You entered number: \"5\"", driver.findElement(By.id("result_number")).getText());


    }

    @And("^I enter number <number> in number field$")
    public void iEnterNumberNumberInNumberField() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


    @Then("^I see text: \"([^\"]*)\"<number>\"([^\"]*)\"$")
    public void iSeeTextNumber(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^I enter number <number> in number fieldx$")

    public void iEnterNumberNumberInNumberFieldx(String num) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("number")).sendKeys(num);


        // @Then("^I see text: \"([^\"]*)\"(\\d+)\"([^\"]*)\"$")
        //public void iSeeText(String expectedText) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //    String actualText = driver.findElement(By.id("result_number")).getText();
        //   assertEquals(expectedText, actualText);

//}
    }

    @Given("^I am on Enter a number page$")
    public void iAmOnAgePageToNumber() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter number field : \"([^\"]*)\"$")
    public void iShouldEnterNumberFieldNumber(String number) throws Throwable {
        driver.findElement(By.id("numb")).sendKeys(number);
    }

    @And("^I click Submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.xpath("//button[@class='w3-btn w3-orange w3-margin']")).click();
    }

    @Then("^I should see message: \"([^\"]*)\"$")
    public void TheniSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.cssSelector("#ch1_error")).getText());

    }


    @Then("^I should see answer message: \"([^\"]*)\"$")
    public void iShouldSeeAnswerMessageNumberIsAnswer(String answer) throws Throwable {
        Alert alert = (driver.switchTo().alert());
        assertEquals(answer, alert.getText());
    }

}















