package ua.kiev.prog.automation.ui.zvisno.steps;

import ua.kiev.prog.automation.base.Config;
import ua.kiev.prog.automation.ui.zvisno.LoginSelenidePage;
import ua.kiev.prog.automation.ui.zvisno.base.CommandBasePage;

public class LoginSteps {
    final  private LoginSelenidePage loginPage = new LoginSelenidePage();

    final  public CommandBasePage login (String username, String password) {
        loginPage.login.val(username);
        loginPage.passwd.val(password);
        loginPage.submitButton.click();
        return new CommandBasePage();

    }
    final  public CommandBasePage loginWithDefaultCredentials (){
        return this.login(Config.SITE_USERNAME.value, Config.SITE_PASSWORD.value);
    }
}
