package Other;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OtherPage {
    private WebDriver driver;

    public OtherPage(WebDriver driver) {
        this.driver = driver;
    }

    private By submitButton = By.xpath("//input[@id='scroll-button']");
    private By mark = By.xpath("//p[@class='lead high-site-paragraph show-button']");


    public OtherPage scrollToElement() {
        WebElement buttonMark = driver.findElement(mark);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                , buttonMark);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -200)");
        WebDriverWait wait = new WebDriverWait(driver, 12);
        wait.until(ExpectedConditions.visibilityOfElementLocated(submitButton));
        return this;
    }

    public void takeScreenshot() {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh-mm-ss dd-MM-yyyy");
        String filename = format.format(dateNow) + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
