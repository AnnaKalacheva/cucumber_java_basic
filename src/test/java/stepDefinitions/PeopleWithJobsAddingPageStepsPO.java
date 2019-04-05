package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.PeopleWithJobsAddingPage;
import pages_sample.PeopleWithJobsPage;

public class PeopleWithJobsAddingPageStepsPO {

    private WebDriver driver;
    //static PeopleWithJobsPage peopleWithJobsPage;
    static PeopleWithJobsAddingPage peopleWithJobsAddingPage;

    public PeopleWithJobsAddingPageStepsPO() {
        this.driver = Hooks.driver;
        //peopleWithJobsPage = PageFactory.initElements(Hooks.driver, PeopleWithJobsPage.class);
        peopleWithJobsAddingPage = PageFactory.initElements(Hooks.driver, PeopleWithJobsAddingPage.class);
    }

    @And("^I enter Name \"([^\"]*)\"$")
    public void iEnterName(String name) {
        peopleWithJobsAddingPage.enterName(name);
    }

    @And("^I enter Job Title: \"([^\"]*)\"$")
    public void iEnterJobTitle(String jobTitle) {
        peopleWithJobsAddingPage.enterJobTitle(jobTitle);
    }

    @Then("^I click Add button$")
    public void iClickAddButton() {
        peopleWithJobsAddingPage.clickAddButton();
    }

    @Then("^I click Clear all button and I see all lines are empty$")
    public void iClickClearAllButtonAndISeeAllLinesAreEmpty() throws Throwable {
        peopleWithJobsAddingPage.checkClickClearAllButton();
    }
}
