package ua.kiev.prog.automation.ui.zvisno.base;

import ua.kiev.prog.automation.base.page.BasePage;
import ua.kiev.prog.automation.ui.zvisno.ShoppingCart.ShoppingCartTotal;
import ua.kiev.prog.automation.ui.zvisno.menu.MainMenuBlock;
import ua.kiev.prog.automation.ui.zvisno.menu.TopMenuBlock;
import ua.kiev.prog.automation.ui.zvisno.widgets.CartWidget;
import ua.kiev.prog.automation.ui.zvisno.widgets.SearchWidget;

public class CommandBasePage extends BasePage {

    final public TopMenuBlock       topMenu = new TopMenuBlock();
    final public CartWidget         cart = new CartWidget();
    final public SearchWidget       search = new SearchWidget();
    final public MainMenuBlock      mainMenu = new MainMenuBlock();
    final public ShoppingCartTotal  shoppingCartTotal = new ShoppingCartTotal();

}
