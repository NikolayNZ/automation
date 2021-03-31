package ua.kiev.prog.automation.TestNG;

import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.ui.zvisno.MainPage;
import ua.kiev.prog.automation.ui.zvisno.utils.Utils;

public class getCurrency  extends UITest {

    final private MainPage mainPage = new MainPage();

    @Test
    public void checkCurrency() {
        for (String currency : Utils.db.currency.getCurrency()) {
            System.out.println(currency);
            mainPage.topMenu.currency.selectValue(currency);
        }
    }

    @Test
    public void checkCurrencyEuro () {
        for (String currency : Utils.db.currency.getCurrencyEuro()) {
            System.out.println(currency);
            mainPage.topMenu.currency.selectValue(currency);
        }
    }
}
