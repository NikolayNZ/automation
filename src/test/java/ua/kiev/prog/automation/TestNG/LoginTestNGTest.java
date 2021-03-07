package ua.kiev.prog.automation.TestNG;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.kiev.prog.automation.base.UITestNGTest;
import ua.kiev.prog.automation.ui.zvisno.LoginPage;

    @Test
    public class LoginTestNGTest extends UITestNGTest {

    final private LoginPage loginPage = new LoginPage();

     @DataProvider (name = "loginData")
        public Object[][] loginData(){
            return new Object[][] {
                {"invalidLogin",                 "12345678" ,            "Предупреждение: Не совпадает адрес электронной почты и/или пароль."},//invalid login
                {"yurii.voronenko@gmail.com",    "InvalidPassword",      "Предупреждение: Не совпадает адрес электронной почты и/или пароль."},//invalid password
                {"yurii.voronenko@gmail.com",    "12345678",              null},//valid
                {"Yurii.voronenko@gmail.com",    "12345678",              null},//VALID UPPERCASE

        };
    }
    @Test (dataProvider = "loginData")
    public void loginTest (String username, String password, String errorMessage) throws Exception{
      loginPage.login(username, password);
        if(errorMessage != null){
            Assert.assertEquals(errorMessage, loginPage.getErrorMessage().get(0), "Error message is not to expected");
        }else {
            Assert.assertEquals(0, loginPage.getErrorMessage().size(), "Error message is present");
        }
    }

    }