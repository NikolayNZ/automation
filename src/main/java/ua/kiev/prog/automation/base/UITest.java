package ua.kiev.prog.automation.base;

import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class UITest {

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

