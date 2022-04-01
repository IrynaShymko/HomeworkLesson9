package Interactions;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Draggable {
    WebDriver driver;

    public Draggable(WebDriver driver) {
        this.driver = driver;
    }
    private By square = By.xpath("//div[@id='draggable']");

    public WebElement move(int x, int y) {
        WebElement squareElement = driver.findElement(square);
        Actions action = (new Actions(driver)).dragAndDropBy(squareElement, x, y);
        action.perform();
        return squareElement;
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
