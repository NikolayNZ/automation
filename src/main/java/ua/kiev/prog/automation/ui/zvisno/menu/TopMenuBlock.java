package ua.kiev.prog.automation.ui.zvisno.menu;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ua.kiev.prog.automation.base.page.BasePage;
import ua.kiev.prog.automation.ui.zvisno.widgets.CustomSelectBox;

public class TopMenuBlock extends BasePage {

    final private SelenideElement _self = Selenide.$x("//nav[@id='top']");

    final public CustomSelectBox currency = new CustomSelectBox(_self.$x(".//form[@id='form-currency']"));
    final public CustomSelectBox language = new CustomSelectBox(_self.$x(".//form[@id='form-language']"));

    final public CustomSelectBox account = new CustomSelectBox(_self.$x(".//a[contains(@href, 'account/account')/..]"));


}
