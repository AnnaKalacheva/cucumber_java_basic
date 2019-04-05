package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages_sample.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class Task2POSteps {
    private WebDriver driver;
    static Task2Page t2Page;
    static Task2EditorPage t2EditorPage;

    public Task2POSteps() {
        this.driver = Hooks.driver;
        t2Page = PageFactory.initElements(Hooks.driver, Task2Page.class);
        t2EditorPage = PageFactory.initElements(Hooks.driver, Task2EditorPage.class);
    }

    @Given("^I am on page of persons with a job$")
    public void iAmOnPageOfPersonsWithAJob() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/list_of_people");
    }


    @When("^I press Add Person using PO$")
    public void iPressAddPersonUsingPO() throws Throwable {
        t2Page.addpersonButton();

    }

    @And("^I enter name: (.+) using PO$")
    public void iEnterNameNameUsingPO(String name) throws Throwable {
       t2Page.enterName(name);
    }

    @And("^I enter surname: (.+) using PO$")
    public void iEnterSurnameSurnameUsingPO(String surname) throws Throwable {
        t2Page.enterSurname(surname);
    }

    @And("^I enter job: (.+) using PO$")
    public void iEnterJobJobUsingPO(String job) throws Throwable {
        t2Page.enterJob(job);
    }

    @And("^I enter birth date: (.+) using PO$")
    public void iEnterBirthDateDateUsingPO(String date) throws Throwable {
        t2Page.enterDate(date);
    }

    @And("^I choose languages:  using PO$")
    public void iChooseLanguagesLangUsingPO() throws Throwable {
        t2Page.spanishLanguage();
    }

    @And("^I choose gender: (.+) using PO$")
    public void iChooseGenderGenderUsingPO(String gender) throws Throwable {
        if (gender.equals("Male")) {
            t2Page.selectMaleGender();
        } else {
            t2Page.selectFemaleGender();
        }
    }

    @And("^I choose Employee Status: (.+) using PO$")
    public void iChooseEmployeeStatusStatusUsingPO(String intern) throws Throwable {
        t2Page.statusIntern(intern);

    }

    @Then("^I perform the action of adding the person using PO$")
    public void iPerformTheActionOfAddingThePersonUsingPO() throws Throwable {
        t2Page.addAPersonNow();
        Thread.sleep(2000);

    }


    @And("^I open person editor using PO$")
    public void iOpenPersonEditorUsingPO() throws Throwable {
        t2Page.editNewPerson();
        Thread.sleep(3000);
    }

    @And("^I change persons name to (.+) using PO$")
    public void iChangePersonsNameToNewNameUsingPO(String newName) throws Throwable {
       t2EditorPage.changePersonsName(newName);
       Thread.sleep(2000);
    }

    @And("^I press edit person$")
    public void iPressEditPerson() throws Throwable {
        driver.get("https://kristinek.github.io/site/tasks/enter_a_new_person.html?id=3");
        Thread.sleep(2000);
    }

    @And("^I delete the person$")
    public void iDeleteThePerson() throws Throwable {
       t2Page.deleteNewPerson();
       Thread.sleep(2000);
    }


    @And("^I reset the person list using PO$")
    public void iResetThePersonListUsingPO() throws Throwable {
       t2Page.resetPersonList();
       Thread.sleep(5000);
    }


    @And("^I press Add new person using PO$")
    public void iPressAddNewPersonUsingPO() throws Throwable {
        t2Page.addpersonButton();
    }

    @And("^I input the name using PO$")
    public void iInputTheNameUsingPO(String name1) throws Throwable {
        t2Page.enterName(name1);
    }

    @And("^I input the name using PO (.+)$")
    public void iInputTheNameUsingPOName(String name1) throws Throwable {
        t2Page.enterName(name1);
    }

    @And("^I clear the data by button using PO$")
    public void iClearTheDataByButtonUsingPO() throws Throwable {
       t2Page.clearDataNow();
       Thread.sleep(2000);
    }

    @Then("^I check if input is empty$")
    public void iCheckIfInputIsEmpty() throws Throwable {

    }
}

