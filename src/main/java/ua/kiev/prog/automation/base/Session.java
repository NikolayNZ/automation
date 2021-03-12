package ua.kiev.prog.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Random;

public class Session {
   final static ThreadLocal<Session>_instance = new ThreadLocal<>();


    public static Session getInstance() {
        if (_instance.get() == null){
            _instance.set(new Session());
        }
        return _instance.get();
    }

    private WebDriver _driver;
    private Session(){}
    public WebDriver wd (){
        if (_driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");
            _driver = new ChromeDriver(options);
        }
        return _driver;
    }
    public void takeScreenshot(){
        if(_driver != null) {
            TakesScreenshot tsc = (TakesScreenshot) _driver;
            File tmpFile = tsc.getScreenshotAs(OutputType.FILE);
            Random random = new Random();
            String randFileName = Instant.now().getEpochSecond() + "_" + random.nextInt(10000);
            File dstFile = new File("./target/screenshot_" + randFileName + ".png");
            try {
                FileUtils.copyFile(tmpFile, dstFile);
            } catch (IOException e) {/*Ignore*/}
        }
    }
    public void close() {
        if(_driver != null)
            _driver.quit();
        _driver = null;
    }
}
