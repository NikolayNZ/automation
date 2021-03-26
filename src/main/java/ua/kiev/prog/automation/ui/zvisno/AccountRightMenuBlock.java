package ua.kiev.prog.automation.ui.zvisno;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.SearchContext;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.base.page.BasePage;
import ua.kiev.prog.automation.ui.zvisno.base.CommandBasePage;

import static com.codeborne.selenide.Selenide.$x;

public class AccountRightMenuBlock  extends CommandBasePage {

    final public SelenideElement account = $x(rightMenuLocator("account"));


    final public String rightMenuLocator (String rightMenu){
        return String.format ("//a[@data-autoid='" + rightMenu + "']");
    }

    public boolean isLinkDisplayed(String rightMenu) {
       return $x(rightMenuLocator(rightMenu)).isDisplayed();

    }
}
