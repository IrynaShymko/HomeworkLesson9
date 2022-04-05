package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class DatePicker {
    private WebDriver driver;

    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    private By calendarField = By.xpath("//input[@id='datepicker']");
    private By yearValueInRow = By.xpath("//span[@class='ui-datepicker-year']");
    private By arrowNext = By.xpath("//a[@data-handler='next']/span");
    private By arrowPrev = By.xpath("//a[@data-handler='prev']");
    private By dayToday = By.xpath("//td[contains(@class, 'ui-datepicker-today')]");
    private By dayFirstOfNextMonth = By.xpath("//a[@class='ui-state-default']");
    private By dayLastInJanuaryNextYear = By.xpath("(//td[contains(@data-month, '0')])[last()]");
    private By alreadySelectedDay = By.xpath("//td[@class='  ui-datepicker-current-day']/a");
    private By allDaysOfPreviousMonth = By.xpath("//a[@class='ui-state-default']");

    public void walk() throws InterruptedException {
        selectToday();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        selectFirstDayOfNextMonth();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        Thread.sleep(2000);
        selectLastDayOfJanuaryNextYear();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        selectAlreadySelectedDay();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        selectRandomDayFromPreviousMonth();
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));
        driver.findElement(calendarField).clear();
        driver.findElement(calendarField).sendKeys(generateRandomDateFromLastYear());
        System.out.println("DATE IS: " + driver.findElement(calendarField).getAttribute("value"));

    }

    public void selectToday() {
        driver.findElement(calendarField).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(dayToday))).click();
    }

    public int getNextYear() {
        Calendar cal = Calendar.getInstance();
        int nextYear = cal.get(Calendar.YEAR) + 1;
        return nextYear;
    }

    public void goToNextYear() {
        int nextYear = getNextYear();
        driver.findElement(calendarField).click();
        for (int i = 0; i < 12; i++) {
            if (Integer.parseInt(driver.findElement(yearValueInRow).getText()) != nextYear) {
                driver.findElement(arrowNext).click();
            }
        }
    }

    public void selectLastDayOfJanuaryNextYear() {
        driver.findElement(calendarField).click();
        goToNextYear();
        driver.findElement(dayLastInJanuaryNextYear).click();
    }

    public void goToNextMonth() {
        driver.findElement(calendarField).click();
        driver.findElement(arrowNext).click();
    }

    public void selectFirstDayOfNextMonth() {
        goToNextMonth();
        driver.findElement(dayFirstOfNextMonth).click();
    }

    public void selectAlreadySelectedDay() {
        driver.findElement(calendarField).click();
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(alreadySelectedDay))).click();
    }

    public void goToPreviousMonth() {
        driver.findElement(calendarField).click();
        driver.findElement(arrowPrev).click();
    }

    public void selectRandomDayFromPreviousMonth() {
        goToPreviousMonth();
        List<WebElement> previousMonthDaysList = driver.findElements(allDaysOfPreviousMonth);
        int index = new Random().nextInt((previousMonthDaysList.size()));
        previousMonthDaysList.get(index).click();
    }

    public int getLastYear() {
        Calendar cal = Calendar.getInstance();
        int lastYear = cal.get(Calendar.YEAR) - 1;
        return lastYear;
    }

    public int generateRandomMonth() {
        int month = new Random().nextInt(13);
        return month;
    }

    public int generateRandomDay(int month) {
        switch (month) {
            case (1):
            case (3):
            case (5):
            case (7):
            case (8):
            case (10):
            case (12): {
                int day = new Random().nextInt(31);
                return day;
            }
            case (4):
            case (6):
            case (9):
            case (11): {
                int day = new Random().nextInt(30);
                return day;
            }
            default:
                int day = new Random().nextInt(28);
                return day;
        }
    }

    public String generateRandomDateFromLastYear() {
        int year = getLastYear();
        int month = generateRandomMonth();
        int day = generateRandomDay(month);
        String randomDate = month + "/" + day + "/" + year;
        return randomDate;
    }
}
