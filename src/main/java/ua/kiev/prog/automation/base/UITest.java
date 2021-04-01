package ua.kiev.prog.automation.base;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ua.kiev.prog.automation.API;
import ua.kiev.prog.automation.Steps;

public class UITest {

    final protected Steps steps = new Steps();
    final protected API api     = new API();

    @BeforeSuite (alwaysRun = true)
    public void setupAllureReports (){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true)

        );

    }

        @BeforeMethod (alwaysRun = true)
        public void beforeMethod() {
            WebDriverRunner.setWebDriver(Session.getInstance().wd());
            Session.getInstance().wd().get (Config.BASE_URL.value + "/index.php?route=account/login");


        }
      @AfterMethod (alwaysRun = true)
       public void afterMethod() {
           Session.getInstance().close();
       }
    }

