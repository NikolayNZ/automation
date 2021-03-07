package ua.kiev.prog.automation.hwmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ua.kiev.prog.automation.base.UIJUnitTest;

public class MainMenuJUnitPage {

    final private UIJUnitTest _menu;

    public MainMenuJUnitPage(UIJUnitTest menu) {
        this._menu = menu;
    }


    final private By mainMenuLocator(String menuItem) {
        return By.xpath("//nav[@id='menu']//ul/li/a[text()='" + menuItem + "']");
    }

    final private By getSubMenuItemLocator(String subMenuItem) {
        return By.xpath("..//div[contains(@class, 'dropdown-menu')]//ul/li/a[contains(text(),'" + subMenuItem + "')]");
    }
    public void goToMenu (String menuItem) {
        WebElement menuItemTest = _menu.driver.findElement(mainMenuLocator(menuItem));
        menuItemTest.click();
    }
    public void goToSubMenu(String menuItem, String subMenuItem) {
        WebElement menuItemTest = _menu.driver.findElement(mainMenuLocator(menuItem));
        menuItemTest.click();
        WebElement subMenuItemTest = menuItemTest.findElement(getSubMenuItemLocator(subMenuItem));
        subMenuItemTest.click();
    }
}

