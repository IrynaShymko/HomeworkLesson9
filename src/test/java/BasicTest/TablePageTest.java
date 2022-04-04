package BasicTest;

import Basic.Table;
import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TablePageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("IframePageTest.class");
    private By tableBy = By.xpath("//table");

    @Tag("Basic")
    @Tag("Table")
    @Test
    public void navigateToTable() {
        driver.get("https://seleniumui.moderntester.pl/");
        WebElement tableElement = driver.findElement(tableBy);
        Table table = new Table(tableElement, driver);
        table.showInfoAboutMountainsByStateAndHeight("Switzerland", 4000);
    }
}