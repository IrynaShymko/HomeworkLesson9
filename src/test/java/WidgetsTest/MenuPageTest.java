package WidgetsTest;

import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuPageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("MenuPageTest.class");
    private By menu1 = By.xpath("//*[contains(text(), 'Music')]");
    private By menu2 = By.xpath("//*[contains(text(), 'Jazz')]");
    private By menu3 = By.xpath("//*[contains(text(), 'Modern')]");

    @Tag("Widgets")
    @Tag("Menu")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/menu-item.php"})

    public void moveToMusicJazzModern(String url) {
        driver.get(url);
        driver.findElement(menu1).click();
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOfElementLocated(menu2)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(menu3)).click();
    }
}
