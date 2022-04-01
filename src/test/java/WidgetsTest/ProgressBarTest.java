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

public class ProgressBarTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("ProgressBarTest.class");
    private By progressBar = By.xpath("//div[@id='progressbar']");

    @Tag("Widgets")
    @Tag("Progressbar")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/progressbar.php"})
    public void waitUntilCompleteIsShown(String url){
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(progressBar, "Complete!"));
    }
}
