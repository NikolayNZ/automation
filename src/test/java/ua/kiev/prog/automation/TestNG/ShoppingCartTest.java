package ua.kiev.prog.automation.TestNG;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.ui.zvisno.MainPage;

public class ShoppingCartTest extends UITest {
    final private MainPage mainPage = new MainPage();

    @Test
    public void checkShoppingCart(){
        mainPage.mainMenu.goToSubMenu("Desktops","Mac");
        mainPage.shoppingCartTotal.addToCartProduct.click(); //добавление товара в корзину
        Assert.assertEquals(mainPage.getProductItemsCount(),(Integer) 1);
        Session.getInstance().waitLoading();

        mainPage.cart.click();
        mainPage.shoppingCartTotal.viewCartProducts.click();//просмотр корзины
        Assert.assertEquals(mainPage.cart.getItemsCount(),(Integer) 1);
        Assert.assertEquals(mainPage.cart.getTotalSum(), "$122.00");

        mainPage.cart.click();
        mainPage.shoppingCartTotal.clickPhotoProduct(); //нажать на фото
        Assert.assertEquals(mainPage.cart.getItemsCount(),(Integer) 1);
        Assert.assertEquals(mainPage.cart.getTotalSum(), "$122.00");

        mainPage.cart.click();
        mainPage.shoppingCartTotal.clickNameProduct(); //нажать на имя продукта
        Assert.assertEquals(mainPage.cart.getItemsCount(),(Integer) 1);
        Assert.assertEquals(mainPage.cart.getTotalSum(), "$122.00");

        mainPage.cart.click();
        mainPage.shoppingCartTotal.clickCheckoutProduct(); //перейти на оформление продукта
        Assert.assertEquals(mainPage.cart.getItemsCount(),(Integer) 1);
        Assert.assertEquals(mainPage.cart.getTotalSum(), "$122.00");

        mainPage.cart.click();
        mainPage.shoppingCartTotal.clickRemoveProduct();//удаление продукта
        Assert.assertEquals(mainPage.cart.getItemsCount(),(Integer) 0);
        Assert.assertEquals(mainPage.cart.getTotalSum(), "$0.00");
    }
}
