package ua.kiev.prog.automation.ui.zvisno.menu;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ua.kiev.prog.automation.base.page.BasePage;
import ua.kiev.prog.automation.ui.zvisno.widgets.CustomSelectBox;

import static com.codeborne.selenide.Selenide.$x;

public class MainMenuBlock extends BasePage {

    final private String mainMenuLocatorTemplate = "//nav[@id='menu']//ul/li/a[text()='%s']";
    final private String subMenuLocatorTemplate  = "..//div[contains(@class, 'dropdown-menu')]//ul/li/a[contains(text(),'%s')]";


    public void goToMenu(String menuItem) {
        SelenideElement elem = $x (String.format(mainMenuLocatorTemplate, menuItem));
        elem.click();
    }

    public void goToSubMenu(String menuItem, String subMenuItem) {
        SelenideElement elem = $x (String.format(mainMenuLocatorTemplate ,menuItem));
        elem.click();
        SelenideElement sub = elem.$x (String.format(subMenuLocatorTemplate,subMenuItem));
        sub.click();
    }
}
