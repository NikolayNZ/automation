package ua.kiev.prog.automation.base;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.kiev.prog.automation.API;
import ua.kiev.prog.automation.Steps;

public class UITest {

    final protected Steps steps = new Steps();
    final protected API api     = new API();

        @BeforeMethod (alwaysRun = true)
        public void beforeEach () {
            WebDriverRunner.setWebDriver(Session.getInstance().wd());
            Session.getInstance().wd().get (Config.BASE_URL.value + "/index.php?route=account/login");


        }
      @AfterMethod (alwaysRun = true)
       public void afterEach () {
           Session.getInstance().close();
       }
    }

