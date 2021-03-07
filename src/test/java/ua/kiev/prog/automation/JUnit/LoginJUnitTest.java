package ua.kiev.prog.automation.JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ua.kiev.prog.automation.base.UIJUnitTest;
import ua.kiev.prog.automation.ui.zvisno.LoginPage;

public class LoginJUnitTest extends UIJUnitTest {

        final private LoginPage loginPage = new LoginPage();

        private enum LoginData{
            INVALID_LOGIN("invalidUser",                   "12345678",       "Предупреждение: Не совпадает адрес электронной почты и/или пароль."),
            INVALID_PASSWORD("yurii.voronenko@gmail.com",  "invalidPassword","Предупреждение: Не совпадает адрес электронной почты и/или пароль."),
            VALID("yurii.voronenko@gmail.com",             "12345678",        null),
            VALID_UPPERCASE ("Yurii.voronenko@gmail.com",  "12345678",        null);

            final public String username;
            final public String password;
            final public String errorMessage;

            LoginData (String userName, String password, String errorMessage){
                this.username       = userName;
                this.password       = password;
                this.errorMessage   = errorMessage;
            }
        }

        @ParameterizedTest
        @EnumSource(LoginData.class)
        public void testMethod(LoginData data) throws Exception {
            loginPage.login(data.username, data.password);
           if(data.errorMessage != null){
               Assertions.assertEquals(data.errorMessage, loginPage.getErrorMessage().get(0));
           }else {
               Assertions.assertEquals(0, loginPage.getErrorMessage().size());
           }
        }
}
