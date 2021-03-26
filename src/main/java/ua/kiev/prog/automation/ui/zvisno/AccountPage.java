package ua.kiev.prog.automation.ui.zvisno;

import static com.codeborne.selenide.Selenide.*;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.base.page.BasePage;
import ua.kiev.prog.automation.ui.zvisno.base.CommandBasePage;


public class AccountPage extends CommandBasePage {
    final public AccountRightMenuBlock rightMenu = new AccountRightMenuBlock();

    final public SelenideElement accountMenuDropdown = $x ("//ul[@class='list-inline']//a[@class='dropdown-toggle')]");
    final public SelenideElement accountMenuLink = $x ("//ul[contains(@class,'dropdown-menu-right')]//a[contains(@href,'/account')]");

    public void goToAccountMenu (){
        accountMenuDropdown.click();
        accountMenuLink.click();
    }
}
