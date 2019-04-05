package pages_sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class PeopleWithJobs {
    @FindBy(how = How.XPATH, using = "//button[contains(.,'Add')]")
    private WebElement buttonAddPerson;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'Reset')]")
    private WebElement buttonResetList;

    @FindBy(how = How.XPATH, using = "//button[contains(.,'Reset')]")// ne gotov
    private WebElement crossIcon;

    @FindBy(how = How.XPATH, using = "//i[@class='fa fa-pencil']")
    private List<WebElement>  editButtonPencil;

    @FindBy(how = How.XPATH, using = "//li[contains(@id, 'person')]")
    private List<WebElement> persons;

    @FindBy(how = How.XPATH, using = "//span[contains(@onclick, 'deletePerson')]")// not
    private List<WebElement> crossButton;

    @FindBy(how = How.CSS, using = ".name")
    private List<WebElement> nameList;

    @FindBy(how = How.CSS, using = ".job")
    private List<WebElement> jobList;


    @FindBy(how = How.CSS, using = "#addPersonBtn")
    private WebElement addPerson;


    public void pressAddPerson(){
        buttonAddPerson.click();
    }



    public void resetPersonList(){
        buttonResetList.click();
    }

    public void pressEditButtonByIndex(int index){
        editButtonPencil.get(index).click();
    }


    public int findIndexOfLastPerson(){
       return persons.size() - 1;
    }

    public WebElement findNameIndex(int index){
        return nameList.get(index);
    }

    public WebElement findJobIndex(int index){
        return jobList.get(index);
    }
    public WebElement findPersons(int index){
        return persons.get(index);
    }

    public void originalListOfPeopleLeft() {
        assertEquals(3,persons.size());


    }

    public void listWithRemovedPerson() {
        assertEquals(2,persons.size());


    }

    public WebElement findCrossIndex(int index){
        return crossButton.get(index);
    }
}


