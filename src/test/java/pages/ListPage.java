package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ListPage {
    @FindBy(how = How.XPATH, using = "//button[.='Add person']")
    private WebElement addPersonBtn;
    @FindBy(how = How.XPATH, using = "//button[.='Reset List']")
    private WebElement resetListBtn;
    @FindBy(how = How.XPATH, using = "//ul[@id='listOfPeople']/div")
    private List<WebElement> listOfPeople;
    @FindBy(how = How.XPATH, using = "//ul[@id='listOfPeople']")
    private WebElement listOfPeopleContainer;

    private final String[] listOfClasses = {"name", "surname", "job", "dob", "language", "gender", "status"};

    public void clickAddPersonBtn(){
        addPersonBtn.click();
    }

    public void clickEditButton(int index) {
        listOfPeople.get(index).findElement(By.className("editbtn")).click();
    }

    public void clickDeleteButton(int index) {
        listOfPeople.get(index).findElement(By.className("closebtn")).click();
    }

    public ArrayList<LinkedHashMap<String, String>> getList(){
        ArrayList<LinkedHashMap<String, String>> list = new ArrayList<>();
        for (int i = 0; i < listOfPeople.size(); i++) {
            list.add(new LinkedHashMap<>());
            for (String classString: listOfClasses) {
                list.get(i).put(classString, listOfPeople.get(i).findElement(By.className(classString)).getText());
            }
        }
        return list;
    }
    public void clickResetBtn(){
        resetListBtn.click();
    }

    public void checkNoChangeAfterAdd(ArrayList<LinkedHashMap<String, String>> previousList){
        ArrayList<LinkedHashMap<String, String>> list = new ArrayList<>();
        for (LinkedHashMap<String, String> map: previousList) {
            list.add(new LinkedHashMap<>(map));
        }
        list.add(new LinkedHashMap<>());
        checkNoChange(list, 0, listOfPeople.size() - 1);
    }

    public void checkNoChangeAfterEdit(ArrayList<LinkedHashMap<String, String>> previousList, int index) {
        checkNoChange(previousList, 0, index);
        checkNoChange(previousList, index + 1, listOfPeople.size());
    }

    public void checkNoChangeAfterDelete(ArrayList<LinkedHashMap<String, String>> previousList, int index) {
        ArrayList<LinkedHashMap<String, String>> list = new ArrayList<>();
        for (LinkedHashMap<String, String> map: previousList) {
            list.add(new LinkedHashMap<>(map));
        }
        list.remove(index);
        checkNoChange(list);
    }

    public void checkNoChange(ArrayList<LinkedHashMap<String, String>> previousList){
        checkNoChange(previousList, 0, listOfPeople.size());
    }

    public void checkNoChange(ArrayList<LinkedHashMap<String, String>> previousList, int from, int to){
        assertEquals(previousList.size(), listOfPeople.size());
        for (int i = from; i < to; i++) {
            for (String classString: listOfClasses) {
                assertEquals(previousList.get(i).get(classString),
                        listOfPeople.get(i).findElement(By.className(classString)).getText());
            }
        }
    }

    public void checkFieldOfLastPerson(String name, String value){
        checkField(name, value, listOfPeople.size() - 1);
    }

    public void checkField(String name, String value, int index){
        switch (name){
            case "name":{
                checkName(value, index);
                break;
            }
            case "surname":{
                checkSurname(value, index);
                break;
            }
            case "job":{
                checkJob(value, index);
                break;
            }
            case "birthDate":{
                checkDateOfBirth(value, index);
                break;
            }
            case "languages":{
                checkLanguages(value, index);
                break;
            }
            case "gender":{
                checkGender(value, index);
                break;
            }
            case "status":{
                checkEmployeeStatus(value, index);
                break;
            }
            default:{
                throw new InvalidArgumentException("invalid name of the field");
            }
        }
    }

    public void checkNameOfLastPerson(String name){
        checkName(name, listOfPeople.size() - 1);
    }

    public void checkName(String name, int index){
        assertEquals(name, listOfPeople.get(index).findElement(By.className("name")).getText());
    }

    public void checkSurnameOfLastPerson(String surname){
        checkSurname(surname, listOfPeople.size() - 1);
    }

    public void checkSurname(String surname, int index){
        assertEquals(surname, listOfPeople.get(index).findElement(By.className("surname")).getText());
    }

    public void checkJobOfLastPerson(String job){
        checkJob(job, listOfPeople.size() - 1);
    }

    public void checkJob(String job, int index){
        assertEquals(job, listOfPeople.get(index).findElement(By.className("job")).getText());
    }

    public void checkDateOfBirthOfLastPerson(String date){
        checkDateOfBirth(date, listOfPeople.size() - 1);
    }

    public void checkDateOfBirth(String date, int index) {
        assertEquals(date, listOfPeople.get(index).findElement(By.className("dob")).getText());
    }

    public void checkLanguagesOfLastPerson(String languages){
        checkLanguages(languages, listOfPeople.size() - 1);
    }

    public void checkLanguages(String languages, int index) {
        if (languages.isEmpty()){
            assertEquals("undefined", listOfPeople.get(index).findElement(By.className("language")).getText());
        } else {
            assertEquals(languages, listOfPeople.get(index).findElement(By.className("language")).getText());
        }
    }

    public void checkGenderOfLastPerson(String gender){
        checkGender(gender, listOfPeople.size() - 1);
    }

    public void checkGender(String gender, int index){
        if (gender.isEmpty()){
            assertEquals("undefined", listOfPeople.get(index).findElement(By.className("gender")).getText());
        } else {
            assertEquals(gender, listOfPeople.get(index).findElement(By.className("gender")).getText());
        }
    }

    public void checkEmployeeStatusOfLastPerson(String status){
        checkEmployeeStatus(status, listOfPeople.size() - 1);
    }

    public void checkEmployeeStatus(String status, int index){
        if (Character.isUpperCase(status.charAt(0))){
            status = status.replaceFirst("^.",
                    Character.toString(Character.toLowerCase(status.charAt(0))));
        }
        assertEquals(status, listOfPeople.get(index).findElement(By.className("status")).getText());
    }

    public void checkTableNotDisplayed(){
        assertEquals("0px", listOfPeopleContainer.getCssValue("height"));
    }

    public void checkAddPersonBtnIsDisplayed(){
        assertTrue(addPersonBtn.isDisplayed());
    }
}
