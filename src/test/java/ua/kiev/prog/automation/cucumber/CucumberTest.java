package ua.kiev.prog.automation.cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/resources/cucumberTest"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = {"ua.kiev.prog.automation.cucumber"}
)
public class CucumberTest extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
