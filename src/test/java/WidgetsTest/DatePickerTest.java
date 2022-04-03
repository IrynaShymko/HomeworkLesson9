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

import java.util.Calendar;
import java.util.List;
import java.util.Random;


public class DatePickerTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("DatePickerTest.class");

    private By calendarField = By.xpath("//input[@id='datepicker']");
    private By monthValueInRow = By.xpath("//span[@class='ui-datepicker-month']");
    private By yearValueInRow = By.xpath("//span[@class='ui-datepicker-year']");
    private By arrowNext = By.xpath("//a[@data-handler='next']/span");
    private By arrowPrev = By.xpath("//a[@data-handler='prev']/span");
    private By dayToday = By.xpath("//td[contains(@class, 'ui-datepicker-today')]");
    private By dayFirstOfNextMonth = By.xpath("//a[@class='ui-state-default']");
    private By dayLastInJanuaryNextYear = By.xpath("(//td[contains(@data-month, '0')])[last()]");
    private By alreadySelectedDay = By.xpath("//td[@class='  ui-datepicker-current-day']/a");
    private By allDaysOfPreviousMonth = By.xpath("//a[@class='ui-state-default']");

    private By calendarElement = By.xpath("//div[@id='ui-datepicker-div']");

    @Tag("Widgets")
    @Tag("DatePicker")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/datepicker.php"})
    public void walkOnCalendar(String url) throws InterruptedException {
        driver.get(url);
        walk();
    }

    public void walk() throws InterruptedException {
        WebElement calendarFieldElement = driver.findElement(calendarField);
//        calendarFieldElement.sendKeys("07/08/2022");
        selectToday();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        Thread.sleep(2000);
        selectFirstDayOfNextMonth();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        Thread.sleep(2000);
        selectLastDayOfJanuaryNextYear();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        selectAlreadySelectedDay();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        selectRandomDayFromPreviousMonth();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
//        selectRandomDateFromLastYear();
//        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
    }

    public DatePickerTest selectToday() {
        driver.findElement(calendarField).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(dayToday))).click();
        return this;
    }

    public int getNextYear() {
        Calendar cal = Calendar.getInstance();
        int nextYear = cal.get(Calendar.YEAR) + 1;
        return nextYear;
    }

    public DatePickerTest goToNextYear() {
        int nextYear = getNextYear();
        driver.findElement(calendarField).click();
        for (int i = 0; i < 12; i++) {
            if (Integer.parseInt(driver.findElement(yearValueInRow).getText()) != nextYear) {
                driver.findElement(arrowNext).click();
            }
        }
        return this;
    }

    public DatePickerTest selectLastDayOfJanuaryNextYear() {
        driver.findElement(calendarField).click();
        goToNextYear();
        driver.findElement(dayLastInJanuaryNextYear).click();
        return this;
    }

    public DatePickerTest goToNextMonth() {
        driver.findElement(calendarField).click();
        driver.findElement(arrowNext).click();
        return this;
    }

    public DatePickerTest selectFirstDayOfNextMonth() {
        goToNextMonth();
        driver.findElement(dayFirstOfNextMonth).click();
        return this;
    }

    public DatePickerTest selectAlreadySelectedDay() {
        driver.findElement(calendarField).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(alreadySelectedDay))).click();
        return this;
    }

    public DatePickerTest goToPreviousMonth() {
        driver.findElement(calendarField).click();
        driver.findElement(arrowPrev).click();
        return this;
    }

    public DatePickerTest selectRandomDayFromPreviousMonth() {
        goToPreviousMonth();
        List<WebElement> previousMonthDaysList = driver.findElements(allDaysOfPreviousMonth);
        int index = new Random().nextInt((previousMonthDaysList.size()));
        previousMonthDaysList.get(index).click();
        return this;
    }

    public int getLastYear() {
        Calendar cal = Calendar.getInstance();
        int nextYear = cal.get(Calendar.YEAR) -1;
        return nextYear;
    }
    public DatePickerTest goToLastYear() {
        int lastYear = getLastYear();
        driver.findElement(calendarField).click();
        for (int i = 0; i < 12; i++) {
            if (Integer.parseInt(driver.findElement(yearValueInRow).getText()) != lastYear) {
                driver.findElement(arrowPrev).click();
            }
        }
        return this;
    }

    public DatePickerTest goToRandomPreviousMonth(){
        int countOfClickPreviousButton = new Random().nextInt(12);
        for(int i=0; i<countOfClickPreviousButton; i++){
            goToPreviousMonth();
        }return this;

    }
    public void selectRandomDateFromLastYear(){
        goToLastYear();
        goToRandomPreviousMonth();
        selectRandomDayFromPreviousMonth();
    }
}
