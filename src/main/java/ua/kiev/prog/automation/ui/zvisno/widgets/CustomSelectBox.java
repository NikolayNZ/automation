package ua.kiev.prog.automation.ui.zvisno.widgets;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public class CustomSelectBox  {
    final private SelenideElement _self;
    final private SelenideElement _button;
    final private SelenideElement _menuList;

    public CustomSelectBox (SelenideElement self){
        _self = self;
        _button = _self.$x(".//*[@data-toggle='dropdown']");
        _menuList = _self.$x(".//ul[contains(@class,'dropdown-menu')]");
    }
    @Step ("Select checkbox value")
    public void click () {
        this._button.click();
    }

    public List <String> getValues () {
        List<String> result = new ArrayList<>();
        List<SelenideElement> liList = this._menuList.$$x("./li");
        for (SelenideElement elem : liList){
            result.add(elem.getAttribute("innerText").trim());
        }
        return result;
    }

    @Step("Select checkbox value")
    public void selectValue (String value) {
        value = value.trim();
        if (!_menuList.isDisplayed())
            this.click();
        SelenideElement valToSelect = this._menuList.$x("./li[normalize-space()='"+ value +"']");
        if (valToSelect.exists())
            valToSelect.click();
        else
            throw new RuntimeException("Value \"" + value + "\" is not found for select box");

        //is displayed
        //find
        //click
    }
    public boolean hasValue (String value) {
        SelenideElement val = this._menuList.$x("./li[normalize-space()='"+ value +"']");
        return val.exists();
    }
}
