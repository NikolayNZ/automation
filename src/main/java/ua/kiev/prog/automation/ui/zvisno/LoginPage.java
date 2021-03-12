package ua.kiev.prog.automation.ui.zvisno;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.base.page.BasePage;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends BasePage {


    @FindBys(@FindBy(xpath = "//div[contains(@class, 'alert-danger')]"))
    private List <WebElement> errorMessage;
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement loginField;
    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitBtn;

    public void login (String username, String password) {
        loginField.clear();
        loginField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        submitBtn.click();

    }

    public void enterUsername (String username){
        loginField.clear();
        loginField.sendKeys(username);
    }
    public void enterPassword (String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmitButton (){
        submitBtn.click();
    }

    public List<String>getErrorMessage() {
        List<String> result = new ArrayList<>();
        for (WebElement err: errorMessage) {
            try {
               result.add(err.getText());
            }catch (Throwable e) {/*Ignore*/}
        }
        return  result;
    }
}
