package ua.kiev.prog.automation.ui.zvisno;

import com.codeborne.selenide.SelenideElement;
import ua.kiev.prog.automation.base.page.BasePage;
import ua.kiev.prog.automation.ui.zvisno.base.CommandBasePage;

import static com.codeborne.selenide.CollectionCondition.*;

import static com.codeborne.selenide.Selenide.*;


public class MainMenuSelenidePage extends CommandBasePage {

  /*  final private String firstMenuLocator = "//nav[@id='menu']//ul/li/a[text()='%s']";
    final private String secondMenuLocator = "..//div[contains(@class, 'dropdown-menu')]//ul/li/a[contains(text(),'%s')]";

    public void goToMenu(String menuItem) {
        $x (String.format(firstMenuLocator,menuItem)).click();
    }

    public void goToSubMenu1(String menuItem, String subMenuItem) {
        SelenideElement firstMenu = $x (String.format(firstMenuLocator,menuItem));
        firstMenu.click();
        firstMenu.$x(String.format(secondMenuLocator,subMenuItem)).click();
    }*/

    public Integer getProductItemsCount() {
            return $$x ("//div[@id='content']//div[contains(@class,'product-grid')]").size();
        }
    }




