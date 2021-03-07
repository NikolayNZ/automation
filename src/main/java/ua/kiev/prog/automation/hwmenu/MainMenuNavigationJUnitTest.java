package ua.kiev.prog.automation.hwmenu;

import org.junit.jupiter.api.Test;
import ua.kiev.prog.automation.base.UIJUnitTest;

public class MainMenuNavigationJUnitTest extends UIJUnitTest {

    final private MainMenuJUnitPage mainMenuPage = new MainMenuJUnitPage(this);

    @Test
    public void testMethod() throws InterruptedException {
        mainMenuPage.goToMenu("Tablets");
        Thread.sleep(5000);

        mainMenuPage.goToSubMenu("Desktops", "Mac (1)");
        Thread.sleep(5000);
    }
}