package pages_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.*;


public class Task2EditorPage {

    @FindBy (how = How.XPATH, using = "//*[@id=\"name\"]")
    private WebElement changeName;





    public void changePersonsName (String newName){
        changeName.clear();
        changeName.sendKeys(newName);
    }





}
