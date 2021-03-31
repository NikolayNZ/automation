package ua.kiev.prog.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.Map;
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
    private MySQLDriver _mysql;

    private Session(){}
    public WebDriver wd (){
        if (_driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--no-proxy-server");
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            _driver = new ChromeDriver(options);
        }
        return _driver;
    }

    public MySQLDriver mysql(){
        if (_mysql == null)
            _mysql = new MySQLDriver();
        return _mysql;
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
    public JavascriptExecutor js() {
        return (JavascriptExecutor) this.wd();
    }

    public void waitLoading(){
        try{
            Thread.sleep(500);
        } catch (Throwable e) {/*Ignore*/}
        WebDriverWait wait = new WebDriverWait(this.wd(), 30, 500);
        wait.until((webDriver) -> "complete".equals(js().executeScript("return document.readyState")));
        }

       /* @Test
    public void loginIntoWebSite () {
            Response response = RestAssured.given()
                    .param("email", "yurii.voronenko@gmail.com")
                    .param("password", "12345678")
                    .post("http://zvisno.com/index.php?route=account/login")
                    .then().extract().response();
            for (Map.Entry<String, String> cookie: response.getCookies().entrySet()){
                String param = cookie.getKey();
                String value = cookie.getValue();
                this.wd().manage().addCookie(
                       new Cookie(param, value, "zvisno.com/","/",null)
                );
            }
            this.wd().navigate().refresh();
        }*/

    public void loginIntoWebSite () {
        Response response = RestAssured.given()
                .param("email", Config.SITE_USERNAME.value)
                .param("password", Config.SITE_PASSWORD.value)
                .post(Config.BASE_URL.value +"/index.php?route=account/login")
                .then().extract().response();
        System.out.println(response.getStatusCode());
        for (Map.Entry<String, String> cookie : response.getCookies().entrySet()) {
            String param = cookie.getKey();
            String value = cookie.getValue();
            this.wd().manage().addCookie(
                    new Cookie(param,value)
            );
        }
        this.wd().navigate().refresh();
        this.waitLoading();
    }


    public void close() {
        if(_driver != null)
            _driver.quit();
        _driver = null;
    }
}

