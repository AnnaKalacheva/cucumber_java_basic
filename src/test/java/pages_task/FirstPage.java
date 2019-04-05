package pages_task;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import stepDefinitions.Task2StepsPO;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FirstPage {

    @FindBy(how = How.ID, using = "addPersonBtn")
    private List<WebElement> buttons;


    @FindBy(how = How.CLASS_NAME, using = "name")
    private List<WebElement> name;

    @FindBy(how = How.CLASS_NAME, using = "surname")
    private List<WebElement> surname;

    @FindBy(how = How.CLASS_NAME, using = "job")
    private List<WebElement> job;

    @FindBy(how = How.CLASS_NAME, using = "dob")
    private List<WebElement> dob;
    @FindBy(how = How.CLASS_NAME, using = "language")
    private List<WebElement> language;
    @FindBy(how = How.CLASS_NAME, using = "gender")
    private List<WebElement> gender;
    @FindBy(how = How.CLASS_NAME, using = "status")
    private List<WebElement> status;
    @FindBy(how = How.CLASS_NAME, using = "fa-pencil")
    private List<WebElement> edits;
    @FindBy(how = How.XPATH, using = "//*[@class='w3-closebtn closebtn w3-padding w3-margin-right w3-medium']")
    private List<WebElement> delete;
    int sizeOfList;

    ArrayList<ArrayList<String>> arr;
    ArrayList<ArrayList<String>> arr2;


    public ArrayList<ArrayList<String>> list() {
        arr = new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            arr.add(new ArrayList<>());
            arr.get(i).add(name.get(i).getText());
            arr.get(i).add(surname.get(i).getText());
            arr.get(i).add(job.get(i).getText());
            arr.get(i).add(dob.get(i).getText());
            arr.get(i).add(language.get(i).getText());
            arr.get(i).add(gender.get(i).getText());
            arr.get(i).add(status.get(i).getText());

        }


        return arr;
    }

    public ArrayList<ArrayList<String>> list2() {
        arr2 = new ArrayList<>();
        for (int i = 0; i < name.size(); i++) {
            arr2.add(new ArrayList<>());
            arr2.get(i).add(name.get(i).getText());
            arr2.get(i).add(surname.get(i).getText());
            arr2.get(i).add(job.get(i).getText());
            arr2.get(i).add(dob.get(i).getText());
            arr2.get(i).add(language.get(i).getText());
            arr2.get(i).add(gender.get(i).getText());
            arr2.get(i).add(status.get(i).getText());

        }


        return arr2;
    }


    public void resetButton() {

        buttons.get(1).click();
    }

    public void addPersonBtn() {
        sizeOfList = name.size();
        buttons.get(0).click();
    }

    public void edit() {

        edits.get(0).click();
    }

    public void delete() {
        sizeOfList = name.size();
        delete.get(0).click();
    }

    public void addPersonCheck() {
        assertEquals(name.size(), sizeOfList + 1);


        for (int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < 7; j++) {

                assertEquals(arr.get(i).get(j), arr2.get(i).get(j));


            }
        }


        assertEquals(name.get(3).getText(), arr2.get(3).get(0));
        assertEquals(surname.get(3).getText(), arr2.get(3).get(1));
        assertEquals(job.get(3).getText(), arr2.get(3).get(2));
        assertEquals(dob.get(3).getText(), arr2.get(3).get(3));
        assertEquals(language.get(3).getText(), arr2.get(3).get(4));
        assertEquals(gender.get(3).getText(), arr2.get(3).get(5));
        assertEquals(status.get(3).getText(), arr2.get(3).get(6));


    }

    public void deletePersonCheck() {
        assertEquals(name.size(), sizeOfList - 1);

    }
}



