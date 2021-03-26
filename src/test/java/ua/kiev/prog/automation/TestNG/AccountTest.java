package ua.kiev.prog.automation.TestNG;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.base.UITest;

import ua.kiev.prog.automation.ui.zvisno.AccountPage;
import ua.kiev.prog.automation.ui.zvisno.AccountRightMenuBlock;
import ua.kiev.prog.automation.ui.zvisno.base.CommandBasePage;

public class AccountTest extends UITest {


    private AccountRightMenuBlock accountRightMenuBlock = new AccountRightMenuBlock();
    private AccountPage accountPage = new AccountPage();

    public Object[][] accountPageMenu() {
        return new Object[][]{
                {"account"},
                {"account.edit"},
                {"change.password"},
                {"address.list"},
                {"wish.list"},
                {"order.list"},
                {"downloads"},
                {"regular.payments"},
                {"bonuses"},
                {"returns"},
                {"transactions"},
                {"news.latter"},
                {"logout"},

        };
    }

    @Test
    public void testAccountMenu() {
        SoftAssert softAssert = new SoftAssert();
        Session.getInstance().loginIntoWebSite();
        accountPage.goToAccountMenu();
        for (Object[] data: accountPageMenu()) {
            String rightMenu = (String) data[0];
               softAssert.assertTrue(accountPage.rightMenu.isLinkDisplayed(rightMenu));
            Session.getInstance().takeScreenshot();
            Selenide.sleep(1000);
        }
        accountPage.rightMenu.account.click();
        softAssert.assertAll();
    }
}