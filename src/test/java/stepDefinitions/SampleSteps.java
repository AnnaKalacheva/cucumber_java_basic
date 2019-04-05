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
    public void iShouldSeeSomeText() {
        assertTrue(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("p")).getText());
    }

    @When("^I open styles page$")
    public void iOpenStylesPage() {
        driver.get("https://kristinek.github.io/site/examples/styles");
    }

    @Then("^correct header is seen$")
    public void correctHeaderIsSeen() {
        String actualText = driver.findElement(By.tagName("h1")).getText();
        assertEquals("Lorem ipsum", actualText);
    }

    @Given("^I open action page$")
    public void iOpenActionPage() {
        driver.get("https://kristinek.github.io/site/examples/actions");
    }

    @And("^I enter number (\\d+) in number field$")
    public void iEnterNumberInNumberField(String num) {
        driver.findElement(By.id("number")).clear();
        driver.findElement(By.id("number")).sendKeys(num);
    }

    @And("^I click Result$")
    public void iClickResult() {
        driver.findElement(By.id("result_button_number")).click();
    }

    @Then("^I see text: \"(.+)\"$")
    public void iSeeText(String expectedText) throws Throwable {
        String actualText = driver.findElement(By.id("result_number")).getText();
        assertEquals(expectedText, actualText);
    }


    @Given("^I am on number page$")
    public void iOpenActionPage1() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number \n");
    }

    @And("^I enter number: (.*)$")
    public void iEnterNumberInNumberField1(String num) {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(num);
    }

    @And("^I click submit$")
    public void iClickResult1() {
        driver.findElement(By.cssSelector("button")).click();
    }

    @Then("^I see error: (.+)$")
    public void iSeeText1(String expectedText) throws Throwable {
        String actualText = driver.findElement(By.id("ch1_error")).getText();
        assertEquals(expectedText, actualText);
    }

    @Given("^I am on num page$")
    public void iOpenActionPage2() {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_number \n");
    }

    @And("^I enter num: (.*)$")
    public void iEnterNumberInNumberField2(String num) {
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(num);
    }

    @And("^I click submitButton$")
    public void iClickResult2() {
        driver.findElement(By.cssSelector("button")).click();
    }

    @Then("^I see alertMessage: (.+)$")
    public void iSeeText2(String expectedText) throws Throwable {
        Alert alert = driver.switchTo().alert();
        assertEquals(expectedText, alert.getText());
    }

    @Given("^I am on pageObject$")
    public void iOpenPageObject() {driver.get("https://kristinek.github.io/site/tasks/list_of_people_with_jobs.html");}

    @When("^I click on addPersonButton$")
    public void iClickAddPersonButton() {driver.findElement(By.id("addPersonBtn")).click();}

    @And("^I enter name: (.+)$")
    public void iEnterTheName(String name) {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter job: (.+)$")
    public void iEnterJob(String job){
        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click addButton$")
    public void iClickAddButton(){driver.findElement(By.id("modal_button")).click();}

    @Then("^I see theResult: (.*), (.*)$")
    public void iSeeTheResult(String expectedName, String expectedJob){
        //String actualName = driver.findElement(By.id("person3")).getText();
        assertEquals(expectedName, driver.findElement(By.cssSelector("#person3 .name")).getText());

        //String actualJob = driver.findElement(By.id("person3")).getText();
        assertEquals(expectedJob, driver.findElement(By.cssSelector("#person3 .job")).getText());
    }




    @When("^I click edit button$")
    public void iClickEditButton()  {
        driver.findElement(By.xpath("//span[@onclick='openModalForEditPersonWithJob(0)']")).click();
    }

    @And("^I change name and job: (.*), (.*)$")
    public void iChangeNameAndJob(String name, String job)  {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);

        driver.findElement(By.id("job")).clear();
        driver.findElement(By.id("job")).sendKeys(job);
    }

    @And("^I click on edit button again$")
    public void iClickOnEditButtonAgain()  {
        driver.findElement(By.xpath("//button[@onclick='editPersonWithJob(0)']")).click();
    }

    @Then("^I see first person with name and job: (.*), (.*)$")
    public void iSeeFirstPersonWithNameAndJob(String expectedName, String expectedJob)  {
        assertEquals(expectedName, driver.findElement(By.cssSelector("#person0 .name")).getText());
        assertEquals(expectedJob, driver.findElement(By.cssSelector("#person0 .job")).getText());
    }


    @When("^I click on deleting person button$")
    public void iClickOnRemovePersonButton()  {
        driver.findElement(By.xpath("//span[@onclick='deletePerson(0)']")).click();
    }

    @Then("^I do not see deleted person: (.+)$")
    public void iDoNotSeeDeletedPerson(String person)  {
        int elementsSize = driver.findElements(By.id(person)).size();
        assertEquals(0, elementsSize);
    }

    @And("^I click clear all fields button$")
    public void iClickClearAllFieldsButton()  {
        driver.findElement(By.cssSelector("#addPersonBtn")).click();
    }

    @Then("^I see empty fields$")
    public void iSeeEmptyFields() {
        assertEquals("", driver.findElement(By.id("name")).getText());
        assertEquals("", driver.findElement(By.id("job")).getText());
    }


}
