package ua.kiev.prog.automation.ui.zvisno.widgets;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ua.kiev.prog.automation.base.page.BasePage;

public class SearchWidget extends BasePage {
    final public SelenideElement searchFiled = Selenide.$x("//div[@id='search']//input[@name='search']");
    final public SelenideElement searchBtn = Selenide.$x("//div[@id='search']//button[@type='button']");
}
