
package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class feedback {
    private WebDriver driver;


    public feedback() {
        this.driver = stepDefinitions.Hooks.driver;
    }

    @Given("^I am on the Give us your feedback page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @When("^I enter name field : \"([^\"]*)\"$")
    public void iEnterNameField(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).click();
        driver.findElement(By.id("fb_name")).sendKeys(String.valueOf(name));
    }

    @Then("^I enter age field : \"([^\"]*)\"$")
    public void EnterAgeFieldAge(String age) throws Throwable {
        driver.findElement(By.id("fb_age")).click();
        driver.findElement(By.id("fb_age")).sendKeys(String.valueOf(age));

    }

    @Then("^I select Genre: \"([^\"]*)\"$")
    public void iSelectGenre(String genre) throws Throwable {
        driver.findElement(By.xpath("//input[@name='gender' and @value='" + genre + "']")).click();
    }

    @Then("^I choose my opinion : \"([^\"]*)\"$")
    public void iChooseMyOpinion(String option) throws Throwable {
        Select dropdown = new Select(driver.findElement(By.id("like_us")));
        dropdown.selectByValue(option);

    }

    @Then("^I write some comment: \"([^\"]*)\"$")
    public void iWriteSomeComment(String comment) throws Throwable {
        driver.findElement(By.tagName("textarea")).sendKeys(comment);
    }

    @Then("^I click send button$")
    public void iClickSendButton() {
        driver.findElement(By.xpath("//button[@class='w3-btn-block w3-blue w3-section']")).click();

    }

    @Then("^I can check the message \"([^\"]*)\"$")
    public void iCanCheckTheMessage(String text) throws Throwable {
        assertEquals(text, driver.findElement(By.tagName("h2")).getText());
    }

    @And("^I select Language: \"([^\"]*)\"$")
    public void iSelectLanguage(String language) throws Throwable {
        driver.findElement(By.xpath("//input[@value='" + language + "']")).click();
    }

    @Then("^I can see correct options which i filled: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iCanSeeCorrectOptionsWhichIFilled(String name, String age, String language, String genre, String howDoYouLikeUs, String comment) throws Throwable {
        assertEquals(name, driver.findElement(By.id("name")).getText());
        assertEquals(age, driver.findElement(By.id("age")).getText());
        assertEquals(language, driver.findElement(By.id("language")).getText());
        assertEquals(genre, driver.findElement(By.id("gender")).getText());
        assertEquals(howDoYouLikeUs, driver.findElement(By.id("option")).getText());
        assertEquals(comment, driver.findElement(By.id("comment")).getText());
    }

    @Then("^I click no button$")
    public void iClickNoButton() {
        driver.findElement(By.xpath("//button[@class='w3-btn w3-red w3-xlarge']")).click();
    }

    @Then("^I can see what i entered previously: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void iCanSeeWhatIEnteredPreviously(String name, String age, String language, String gender, String option, String comment) throws Throwable {
        assertEquals(name, driver.findElement(By.id("fb_name")).getAttribute("value"));
        assertEquals(age, driver.findElement(By.id("fb_age")).getAttribute("value"));
        assertTrue(driver.findElement(By.xpath("//input[@name='language' and @value='" + language + "']")).isSelected());
        assertTrue(driver.findElement(By.xpath("//input[@name='gender' and @value='" + gender + "']")).isSelected());
        assertEquals(option, driver.findElement(By.id("like_us")).getAttribute("value"));
        assertEquals(comment, driver.findElement(By.name("comment")).getAttribute("value"));
    }

    @Then("^I click yes button$")
    public void iClickYesButton() {
        driver.findElement(By.xpath("//button[@class='w3-btn w3-green w3-xlarge']")).click();
    }


    @Then("^I can see message with correct name: \"([^\"]*)\"$")
    public void iCanSeeMessageWithCorrectName(String finalMessage) throws Throwable {
        assertEquals(finalMessage, driver.findElement(By.id("message")).getText());
    }
}

