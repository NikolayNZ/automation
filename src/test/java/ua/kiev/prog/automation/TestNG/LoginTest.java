package ua.kiev.prog.automation.TestNG;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.Config;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.ui.zvisno.LoginSelenidePage;
import ua.kiev.prog.automation.ui.zvisno.utils.Utils;

@Test
    public class LoginTest extends UITest {

        private LoginSelenidePage loginSelenidePage =  new LoginSelenidePage();

     @DataProvider (name = "loginData")
        public Object[][] loginData(){
            return new Object[][] {
                {"invalidLogin" + Utils.genRandString (10),                              Config.SITE_PASSWORD.value,            "Предупреждение: Не совпадает адрес электронной почты и/или пароль."},//invalid login
                {Config.SITE_USERNAME.value,                  "InvalidPassword",                      "Предупреждение: Не совпадает адрес электронной почты и/или пароль."},//invalid password
                {Config.SITE_USERNAME.value,                  Config.SITE_PASSWORD.value,              null},//valid
                {Config.SITE_USERNAME.value.toUpperCase(),    Config.SITE_PASSWORD.value,              null},//VALID UPPERCASE

        };
    }
    @Test (groups = {"smoke","regression"}, dataProvider = "loginData")
    public void loginTestSelenide (String username, String password, String errorMessage) throws Exception {
        loginSelenidePage.topMenu.language.selectValue("Русский");
        loginSelenidePage.login.val(username);
        loginSelenidePage.passwd.val(password);
        loginSelenidePage.submitButton.click();

        if(errorMessage != null){
            Assert.assertEquals(errorMessage, loginSelenidePage.errorMessages.get(0).text(), "Error message is not equal to expected");
        }else {
            Assert.assertEquals(0, loginSelenidePage.errorMessages.size(), "Error message is present");
        }
     }


       /* @Test (dataProvider = "loginData")
        public void loginTest (String username, String password, String errorMessage) throws Exception{
            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);
            if(errorMessage != null){
                Assert.assertEquals(errorMessage, loginPage.getErrorMessage().get(0), "Error message is not to expected");
            }else {
                Assert.assertEquals(0, loginPage.getErrorMessage().size(), "Error message is present");
            }
        }*/
    }