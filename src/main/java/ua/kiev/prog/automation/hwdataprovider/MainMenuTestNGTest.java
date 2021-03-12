package ua.kiev.prog.automation.hwdataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ua.kiev.prog.automation.base.page.BasePage;

public class MainMenuTestNGTest extends BasePage {

    final private By mainMenuLocator(String menuItem) {
        return By.xpath("//nav[@id='menu']//ul/li/a[text()='" + menuItem + "']");
    }

    final private By subMenuItemLocator(String subMenuItem) {
        return By.xpath("..//div[contains(@class, 'dropdown-menu')]//ul/li/a[contains(text(),'" + subMenuItem + ",')]");

    }

    public void goToMenu(String menuItem) {
        WebElement menuItemTest = driver().findElement(mainMenuLocator(menuItem));
        menuItemTest.click();

    }

    public void goToSubMenu(String menuItem, String subMenuItem) {
        WebElement menuItemTest = driver().findElement(mainMenuLocator(menuItem));
        menuItemTest.click();
        WebElement subMenuItemTest = menuItemTest.findElement(subMenuItemLocator(subMenuItem));
        subMenuItemTest.click();

    }
    public  int getProductItemsCount(){
        return driver().findElements(By.xpath("//div[@id='content']//div[contains(@class,'product-grid')]")).size();
}
    }

