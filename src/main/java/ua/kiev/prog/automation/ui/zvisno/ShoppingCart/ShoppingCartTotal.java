package ua.kiev.prog.automation.ui.zvisno.ShoppingCart;

import com.codeborne.selenide.SelenideElement;
import ua.kiev.prog.automation.base.page.BasePage;

import static com.codeborne.selenide.Selenide.$x;

public class ShoppingCartTotal  extends BasePage {


    final public SelenideElement addToCartProduct = $x ("//button[@type='button']/span[text()='Купить']");
    final public SelenideElement photoProduct = $x("//td[@class='text-center']//a[contains(@href,'/product')]");
    final public SelenideElement nameProduct = $x("//td[@class='text-left']//a[contains(@href,'/product')]");
    final public SelenideElement viewCartProducts = $x("//p[@class='text-right']//a[contains(@href,'/cart')]");
    final public SelenideElement checkoutProduct = $x("//p[@class='text-right']//a[contains(@href,'/checkout')]");
    final public SelenideElement removeProduct = $x ("//td[@class='text-center']//button[@type='button']");


    public void clickViewCard() {
        viewCartProducts.click();
    }

    public void clickPhotoProduct() {
        photoProduct.click();
    }

    public void clickNameProduct() {
        nameProduct.click();
    }

    public  void clickCheckoutProduct(){
        checkoutProduct.click();
    }
    public void clickRemoveProduct(){
        removeProduct.click();
    }
}
