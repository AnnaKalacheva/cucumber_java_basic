package pages_task;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SecondPage {
    String fillName = "Name";
    String fillSurname = "Surname";
    String filJob = "Job";
    String fillDate = "01/01/2000";
    @FindBy(how = How.CLASS_NAME, using = "w3-input")
    private List<WebElement> filds;
    @FindBy(how = How.XPATH, using = "//*[@type='checkbox']")
    private List<WebElement> checkBoxs;
    @FindBy(how = How.XPATH, using = "//*[@type='radio']")
    private List<WebElement> radioButton;
    @FindBy(how = How.TAG_NAME, using = "option")
    private List<WebElement> dropDowns;

    @FindBy(how = How.TAG_NAME, using = "button")
    private List<WebElement> button;

    public void name(String name, String surname) {
        filds.get(0).clear();

        filds.get(0).sendKeys(name);
        filds.get(1).clear();
        filds.get(1).sendKeys(surname);
    }

    public void job(String job, String data) {
        filds.get(2).clear();
        filds.get(2).sendKeys(job);
        filds.get(3).clear();
        filds.get(3).sendKeys(data);
    }

    public void languages(List<String> languages, String gender, String employee) {
        for (int i = 0; i < checkBoxs.size(); i++) {
            if (checkBoxs.get(i).isSelected()) {
                checkBoxs.get(i).click();
            }


        }
        for (int i = 0; i < languages.size(); i++) {
            if (languages.get(i).equals("English")) {
                checkBoxs.get(0).click();
            }
            if (languages.get(i).equals("French")) {
                checkBoxs.get(1).click();
            }
            if (languages.get(i).equals("Spanish")) {
                checkBoxs.get(2).click();
            }
        }


        if (gender.equals("Male")) {
            radioButton.get(0).click();
        }
        if (gender.equals("Female")) {
            radioButton.get(1).click();
        }


        if (employee.equals("Employee")) {
            dropDowns.get(0).click();
        }
        if (employee.equals("Intern")) {
            dropDowns.get(0).click();
        }
        if (employee.equals("Contractor")) {
            dropDowns.get(0).click();
        }


    }

    public void add() throws InterruptedException {

        button.get(1).click();

    }

    public void edit() {
        button.get(0).click();
    }

    public void clear() {

        button.get(0).click();


    }

    public void checkFields() {

        assertEquals("", filds.get(0).getAttribute("value"));
        assertEquals("", filds.get(1).getAttribute("value"));
        assertEquals("", filds.get(2).getAttribute("value"));
        assertEquals("", filds.get(3).getAttribute("value"));

        assertTrue(checkBoxs.get(0).isSelected());
        assertFalse(checkBoxs.get(1).isSelected());
        assertFalse(checkBoxs.get(2).isSelected());

        assertFalse(radioButton.get(0).isSelected());
        assertFalse(radioButton.get(1).isSelected());

        assertTrue(dropDowns.get(0).isSelected());
    }
}
