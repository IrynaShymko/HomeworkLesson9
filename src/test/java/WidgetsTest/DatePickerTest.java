package WidgetsTest;

import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DatePickerTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("DatePickerTest.class");

    private By calendarField = By.xpath("//input[@id='datepicker']");
    private By calendarElement = By.xpath("//div[@id='ui-datepicker-div']");

    @Tag("Widgets")
    @Tag("DatePicker")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/datepicker.php"})
    public void walkOnCalendar(String url) {
        driver.get(url);
        driver.findElement(calendarField).click();
        WebElement calendar = driver.findElement(calendarElement);
        WebDriverWait wait = new WebDriverWait(driver, 7 );
        wait.until(ExpectedConditions.visibilityOf(calendar));





    }
}
