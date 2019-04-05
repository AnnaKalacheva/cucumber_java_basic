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
import org.openqa.selenium.support.ui.Select;

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
      //  Thread.sleep(10000);
  //      assertTrue(driver.findElement(By.className("w3-navbar")).isDisplayed());
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
        System.out.println(driver.findElement(By.tagName("p")));
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I open styles page$")
    public void iOpenStylesPage() throws Throwable {
       driver.get("https://kristinek.github.io/site/examples/styles");
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^correct header is seen$")
    public void correctHeaderIsSeen() throws Throwable {
        assertEquals(driver.findElement(By.tagName("h")).getText(),"Lorem ipsum");

        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I open action page$")
    public void iOpenActionPage() throws Throwable {
        driver.get("https://kristinek.github.io/site/examples/actions");

    }

    @And("^I enter number (\\d+) in number field$")
    public void iEnterNumberInNumberField(int arg0) throws Throwable {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(String.valueOf(arg0));

    }

    @And("^I click Result$")
    public void iClickResult() throws Throwable {


        driver.findElement(By.id("result_button_number")).click();

    }

    @Then("^I see text: \"([^\"]*)\"(\\d+)\"([^\"]*)\"$")
    public void iSeeText(String arg0, int arg1, String arg2) throws Throwable {

        assertEquals(arg0+"\""+arg1+"\"", driver.findElement(By.id("result_number")).getText());

    }

    

    @And("^I enter number \"([^\"]*)\" in number field$")
    public void iEnterNumberInNumberField(String arg0) throws Throwable {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(String.valueOf(arg0));
    }

    @Then("^I see text: You entered number: \"([^\"]*)\"$")
    public void iSeeTextYouEnteredNumber(String arg0) throws Throwable {
        assertEquals("You entered number: "+"\""+arg0+"\"",driver.findElement(By.id("result_number")).getText());
    }

    @When("^enter number(\\d+) too small$")
    public void enterNumberTooSmall(int number) throws Throwable {
        driver.findElement(By.id("numb")).clear();

        driver.findElement(By.id("numb")).sendKeys(String.valueOf(number));
        driver.findElement(By.tagName("button")).click();
        assertEquals("Number is too small",driver.findElement(By.id("ch1_error")).getText());


    }



    @And("^enter number too big$")
    public void enterNumberTooBig() throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys("111");
        driver.findElement(By.tagName("button")).click();
        assertEquals("Number is too big",driver.findElement(By.id("ch1_error")).getText());
    }

    @Then("^enter text instead of the number$")
    public void enterTextInsteadOfTheNumber() throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys("TEST");
        driver.findElement(By.tagName("button")).click();
        assertEquals("Please enter a number",driver.findElement(By.id("ch1_error")).getText());
    }

    @Given("^I am on age pageNumber$")
    public void iAmOnAgePageNumber() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number");
    }

    @And("^enter \"([^\"]*)\"$")
    public void enterTooSmall(String arg0) throws Throwable {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(arg0));
    }

    @And("^I click submit$")
    public void iClickSubmit() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }





    @Then("^I see Alert of \"([^\"]*)\"$")
    public void iSeeAlertOf(int number) throws Throwable {
        Alert alert = driver.switchTo().alert();

        String result = String.format("%.2f", Math.sqrt(number));
        assertEquals("Square root of " + number + " is " + result, alert.getText());
    }

    @When("^I enter :$")
    public void iEnter(List<String> values) throws Throwable {
      List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (int i = 0; i < values.size(); i++) {
            inputs.get(i).clear();
            inputs.get(i).sendKeys(values.get(i));

        }



    }
}
