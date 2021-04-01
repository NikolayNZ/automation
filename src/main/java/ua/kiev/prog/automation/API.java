package ua.kiev.prog.automation;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import ua.kiev.prog.automation.base.Config;
import ua.kiev.prog.automation.base.Session;

import java.util.Map;

public class API {

    final private Session _session = Session.getInstance();


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
            _session.wd().manage().addCookie(
                    new Cookie(param,value)
            );
        }
        _session.wd().navigate().refresh();
        _session.waitLoading();
    }
}
