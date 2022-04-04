package BasicTest;

import Basic.TabsPage;
import Basic.Table;
import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TabsPageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("TabsPageTest.class");
    private By bodyWithTextInMessageWindow = By.xpath("//body");
    private By tableBy = By.xpath("//table");

    @Tag("Basic")
    @Tag("Tabs")
    @Test
    public void shouldSwitchTabs() {
        driver.get("https://seleniumui.moderntester.pl/windows-tabs.php");
        TabsPage tabsPage = new TabsPage(driver);
        String startWindowName = driver.getWindowHandle();

        tabsPage.clickNewBrowserWindowButton();
        tabsPage.switchToLasOpenedWindow();
        WebElement tableElement = driver.findElement(tableBy);
        Table table = new Table(tableElement, driver);
        table.showInfoAboutMountainsByStateAndHeight("Switzerland", 4000);

        driver.close();
        driver.switchTo().window(startWindowName);

        tabsPage.clickNewMessageWindowButton();
        tabsPage.switchToLasOpenedWindow();
        System.out.println(driver.findElement(bodyWithTextInMessageWindow).getText());
        driver.close();
        driver.switchTo().window(startWindowName);

        tabsPage.clickNewBrowserTabButton();
        tabsPage.switchToLasOpenedWindow();
        WebElement tableElement2 = driver.findElement(tableBy);
        Table table2 = new Table(tableElement2, driver);
        table2.showInfoAboutMountainsByStateAndHeight("Switzerland", 4000);
        driver.close();
        driver.switchTo().window(startWindowName);
    }
}
