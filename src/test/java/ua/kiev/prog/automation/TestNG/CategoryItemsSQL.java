package ua.kiev.prog.automation.TestNG;

import org.testng.annotations.Test;
import ua.kiev.prog.automation.base.UITest;
import ua.kiev.prog.automation.ui.zvisno.MainPage;
import ua.kiev.prog.automation.ui.zvisno.utils.Utils;
import ua.kiev.prog.automation.ui.zvisno.utils.dbmodels.CategorySQL;

import java.util.Map;

public class CategoryItemsSQL extends UITest {

    final private MainPage mainPage = new MainPage();

    @Test
    public void checkCategorySQL() {
        for (Map.Entry <Integer, CategorySQL.CategoryItem> map : Utils.db.category.getIdCategory().entrySet()) {
            System.out.println(map);
        }
    }
}
