package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Task2ListPage {

    @FindBy(how = How.ID, using = "addPersonBtn")
    private List<WebElement> buttons;

    @FindBy(how = How.CLASS_NAME, using = "fa-pencil")
    private List<WebElement> editPersonBtn;

    @FindBy(how = How.CLASS_NAME, using = "closebtn")
    private List<WebElement> removeBtns;

    @FindBy(how = How.CLASS_NAME, using = "name")
    private List<WebElement> persons;

    @FindBy(how = How.CLASS_NAME, using = "surname")
    private List<WebElement> personSurname;

    int peopleQty;


    public String getListPageUrl() {
        return "https://kristinek.github.io/site/tasks/list_of_people";
    }

    public void clickAddPersonBtn() {
        peopleQty = persons.size();
        buttons.get(0).click();
    }

    public void editPersonBtn() {
        editPersonBtn.get(0).click();
    }

    public void removePerson() {
        peopleQty = persons.size();
        removeBtns.get(0).click();
    }

    public void resetBtn() {
        peopleQty = persons.size();
        buttons.get(1).click();
    }

    public void checkEdited(String name, String surname) {
        assertEquals(name, persons.get(0).getText());
        assertEquals(surname, personSurname.get(0).getText());
    }

    public void checkAdded() {
        assertEquals(peopleQty + 1, persons.size());
    }

    public void checkRemoved() {
        assertEquals(peopleQty - 1, persons.size());
    }

    public void checkDeleted(String name, String surname) {
        assertFalse(persons.get(0).getText().equals(name));
        assertFalse(personSurname.get(0).getText().equals(surname));
    }



}
