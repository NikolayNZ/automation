package ua.kiev.prog.automation.TestNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.UITestNGTest;
import ua.kiev.prog.automation.hwdataprovider.MainMenuTestNGTest;
import ua.kiev.prog.automation.hwdataprovider.UITestNGSingleSessionTest;
import ua.kiev.prog.automation.ui.zvisno.LoginPage;


    @Test
    public class Product extends UITestNGSingleSessionTest{

        final private MainMenuTestNGTest mainMenuTestNGTest = new MainMenuTestNGTest();

        @DataProvider(name = "productMenu")
        public Object[][] productData() {
            return new Object[][]{
                    {"Desktops",            "PC",      0},//valid
                    {"Desktops",            "Mac",     1},//valid
                    {"Laptops & Notebooks", "Macs",    0},//valid
                    {"Laptops & Notebooks", "Windows", 0},//valid
                    {"Tablets", null, 1},

            };
        }

        @Test(dataProvider = "productMenu")
        public void productMenu(String Menu, String subMenu, Integer count){
            if(subMenu != null) {
                mainMenuTestNGTest.goToSubMenu(Menu, subMenu);
            }else{
                mainMenuTestNGTest.goToMenu(Menu);
            }
            Assert.assertEquals(mainMenuTestNGTest.getProductItemsCount(), java.util.Optional.ofNullable(count));

            }
        }


