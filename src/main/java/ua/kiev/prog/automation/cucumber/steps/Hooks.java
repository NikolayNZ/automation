package ua.kiev.prog.automation.cucumber.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ua.kiev.prog.automation.base.Session;

public class Hooks {
        @Before
        public void before(Scenario scenario) throws Exception {
            System.out.println("Before scenario: " + scenario.getName());
        }

        @After
        public void afterEachScenario(Scenario scenario) {
            System.out.println("After scenario: " + scenario.getName());
            if (scenario.isFailed())
                Session.getInstance().takeScreenshot();

            Session.getInstance().close();
        }
    }
