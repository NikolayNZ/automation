package ua.kiev.prog.automation.TestNG;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ua.kiev.prog.automation.Utils;
import ua.kiev.prog.automation.base.Session;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.ui.zvisno.MainPage;
import ua.kiev.prog.automation.ui.zvisno.utils.dbmodels.Customer;

import java.util.Arrays;
import java.util.List;

public class CommonSmokeTest  extends UITest {

   final private MainPage mainPage = new MainPage();

   public String[] unauthorizedUserAccountItems () {
       return new String[]{
               "Register",
               "Login"
       };
   }
       public String[] authorizedUserAccountItems() {
           return new String[]{
                   "My account",
                   "Order History",
                   "Transactions",
                   "Downloads",
                   "Logout",
           };
       }
          @Test
           public void checkBasicFunctionality () {
              mainPage.mainMenu.goToSubMenu("Desktops", "Mac");
              Assert.assertEquals(mainPage.getProductItemsCount(), (Integer) 1);

              mainPage.search.searchFiled.val("nikon");
              mainPage.search.searchBtn.click();
              Session.getInstance().takeScreenshot();
              //Session.getInstance().waitLoading();
              Assert.assertEquals(mainPage.getProductItemsCount(), (Integer) 1);
              Selenide.$x("//button[@type='button']/span[text()='Купить']").click();

              Assert.assertEquals(mainPage.cart.getItemsCount(), (Integer) 1);
              Assert.assertEquals(mainPage.cart.getTotalSum(), "$98.00");
              mainPage.cart.click();
              Selenide.sleep(1000);
          }


        @Test
               public void checkFunctionality () throws  Throwable{
              System.out.println((mainPage.topMenu.currency.getValues()));
               for (String currency : mainPage.topMenu.currency.getValues()) {
                   mainPage.topMenu.currency.selectValue(currency);
                   Session.getInstance().waitLoading();
               }
               for (String currency : mainPage.topMenu.language.getValues()) {
                   mainPage.topMenu.language.selectValue(currency);
                   Session.getInstance().waitLoading();
               }
               SoftAssert softly = new SoftAssert();
               List<String> unauthAccountItems = Arrays.asList(unauthorizedUserAccountItems());
               List<String> authAccountItems = Arrays.asList(authorizedUserAccountItems());
               mainPage.topMenu.language.selectValue("English");

               System.out.println(mainPage.topMenu.account.getValues());
               compareAccountItems(unauthAccountItems, softly);


               Session.getInstance().loginIntoWebSite();
               mainPage.topMenu.language.selectValue("English");
               System.out.println(mainPage.topMenu.account.getValues());
               compareAccountItems(authAccountItems, softly);

               softly.assertAll();
           }
           private void compareAccountItems (List < String > expectedList, SoftAssert softly){
               for (String item : unauthorizedUserAccountItems()) {
                   softly.assertTrue(mainPage.topMenu.account.hasValue(item));
               }
               for (String item : mainPage.topMenu.account.getValues()) {
                   softly.assertTrue(expectedList.contains(item));
               }
           }

           @Test
           public void testWithDB () {
               System.out.println(Utils.db.customer.getCustomerIDs());
               System.out.println(Utils.db.customer.getCustomerById(1));
           }
       }

