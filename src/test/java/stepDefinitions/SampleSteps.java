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

    //capturing text, we need to define it in public void String or int or other
    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    //capturing number
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
//it shows value or values
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
    public void iOpenStylesPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/styles");
            }

    @Then("^correct header is seen$")
    public void correctHeaderIsSeen() throws Throwable {
         assertEquals("Lorem ipsum", driver.findElement(By.className("w3-jumbo")).getText());

    }

    @Given("^I open action page$")
    public void iOpenActionPage() throws Throwable {
         driver.get("https://kristinek.github.io/site/examples/actions");
    }


    @And("^I enter number: (\\d+)$")
    public void iEnterNumber(int number) throws Throwable {
        driver.findElement(By.name("vfb-9")).clear();
        driver.findElement(By.name("vfb-9")).sendKeys(String.valueOf(number));
                  }

    @And("^I click Result$")
    public void iClickResult() throws Throwable {
        driver.findElement(By.id("result_button_number")).click();
    }

    @Then("^I see Text: You entered number: \"([^\"]*)\"$")
    public void iSeeTextYouEnteredNumber(String text) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals("You entered number: \"5\"", driver.findElement(By.id("result_number")).getText());
            }

///IT IS FOR TASK1
    @Given("^I am on number page$")
    public void iAmOnNumberPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @When("^I enter too small number: \"([^\"]*)\"$")
    public void iEnterNumberOnPage(int numberOnNumberPage) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(numberOnNumberPage));
    }

    @And("^I click submit button$")
    public void iClickSubmitButton() throws Throwable {
        driver.findElement(By.xpath("//*[@class='w3-btn w3-orange w3-margin']")).click();
    }

    @Then("^I see message:\"([^\"]*)\"$")
    public void iSeeMessageOnNumberPage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("ch1_error")).getText());
    }

    @When("^I enter  number: \"([^\"]*)\"$")
    public void iEnterNumberOnNumberPage(String numberOnNumberPage) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(numberOnNumberPage);
    }

    @Then("^I see alert:\"([^\"]*)\"$")
    public void iSeeAlert(String oneAalert) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(oneAalert,alert.getText());
    }
}
