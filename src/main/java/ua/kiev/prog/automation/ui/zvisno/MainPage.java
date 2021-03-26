package ua.kiev.prog.automation.ui.zvisno;

import com.codeborne.selenide.Selenide;

import ua.kiev.prog.automation.ui.zvisno.base.CommandBasePage;

public class MainPage extends CommandBasePage {

    public  Integer getProductItemsCount(){
        return Selenide.$$x ("//div[@id='content']//div[contains(@class,'product-grid')]").size();
}
    }

