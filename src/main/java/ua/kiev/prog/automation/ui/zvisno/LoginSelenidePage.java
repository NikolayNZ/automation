package ua.kiev.prog.automation.ui.zvisno;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.base.page.BasePage;
import ua.kiev.prog.automation.ui.zvisno.base.CommandBasePage;

import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;


public class LoginSelenidePage extends CommandBasePage {

    final public SelenideElement login             = $x("//input[@id='input-email']");
    final public SelenideElement passwd = $x("//input[@id='input-password']");
    final public SelenideElement submitButton      = $x("//input[@type='submit']");
    final public ElementsCollection errorMessages  = $$x("//div[contains(@class, 'alert-danger')]");

    public void login (String username, String password) {
        login.val (username);
        passwd.val(password);
        submitButton.click();
    }

    public void enterUsername (String username){
        login.val (username);
    }
    public void enterPassword (String password){
        passwd.val(password);
    }
    public void clickSubmitButton (){
        submitButton.click();
    }

    public List<String> getErrorMessage() {
        List<String> result = new ArrayList<>();
        for (SelenideElement err: errorMessages) {
            try {
                result.add(err.getText());
            }catch (Throwable e) {/*Ignore*/}
        }
        return  result;
    }
}