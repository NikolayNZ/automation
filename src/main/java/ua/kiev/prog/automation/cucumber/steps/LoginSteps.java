package ua.kiev.prog.automation.cucumber.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.ui.zvisno.LoginPage;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage();

    @When("^I go to login page$")
    public void iGoToLoginPage () throws Exception{
    Session.getInstance().wd().get ("http://zvisno.com/index.php?route=account/login");
    Thread.sleep(1000);
    }
    @And("^I enter username as \"(.+?)\"$")
    public void iEnterUsernameAs(String username) {
        loginPage.enterUsername(username);

    }
    @And("^I enter password as \"(.+?)\"$")
    public void iEnterPasswordAs(String password) {
        loginPage.enterPassword(password);
    }

    @And("^I click submit buttons$")
    public void iClickSubmitButton(){
        loginPage.clickSubmitButton();
    }
    @Then("^Count of error massages must be (\\d+?)$")
    public void countOfErrorMassagesMustBe(int count){
        Assert.assertEquals(loginPage.getErrorMessage().size(),count);
    }
}
