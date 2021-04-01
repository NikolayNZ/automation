package ua.kiev.prog.automation.TestNG;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.kiev.prog.automation.base.Config;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.ui.zvisno.MainPage;
import ua.kiev.prog.automation.ui.zvisno.MainMenuSelenidePage;

public class MainMenuTest extends UITest {

    private MainPage mainPage = new MainPage();

    public Object[][] mainMenuData() {
        return new Object[][]{
                {"Desktops",              "PC",          0},//valid
                {"Desktops",              "Mac",         1},//valid
                {"Laptops & Notebooks",   "Macs",        0},//valid
                {"Laptops & Notebooks",   "Windows",     0},//invalid
                {"Tablets",   null,     1},//invalid
        };
    }

   @Test
    public void testMainMenu() {
       // Session.getInstance().loginIntoWebSite();
       api.loginIntoWebSite();
       steps.login.login(Config.SITE_USERNAME.value, Config.SITE_PASSWORD.value);
        SoftAssert softAssert = new SoftAssert();
        for (Object[] data:mainMenuData()){
            String menu = (String) data[0];
            String subMenu = (String) data[1];
            Integer count = (Integer) data[2];

            if (subMenu != null) {
                mainPage.mainMenu.goToSubMenu(menu, subMenu);
            }else{
                mainPage.mainMenu.goToMenu(menu);
            }
            Session.getInstance().waitLoading();
            Selenide.sleep(1000);
            //Session.getInstance().takeScreenshot();
           softAssert.assertEquals(mainPage.getProductItemsCount(), count,  "count of products does not match" + menu + " ->" + subMenu);
       }
       softAssert.assertAll();

    }



    private MainMenuSelenidePage mainMenuSelenidePage = new MainMenuSelenidePage();

    @Test(dataProvider = "mainMenuData")
    public void setMainMenuSelenidePage(String menu, String subMenu, Integer count) throws InterruptedException {
        if (subMenu != null) {
            mainMenuSelenidePage.mainMenu.goToSubMenu(menu, subMenu);
        }else{
            mainMenuSelenidePage.mainMenu.goToMenu(menu);
        }
        Assert.assertEquals(count, mainMenuSelenidePage.getProductItemsCount());
    }
}

