package Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Resizable {
    private WebDriver driver;

    public Resizable(WebDriver driver) {
        this.driver = driver;
    }

    private By resizeToCorner = By.xpath("//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']");

    public WebElement resizeWindow(int x, int y) {
        WebElement resizePoint = driver.findElement(resizeToCorner);
        Actions builder = new Actions(driver);
        Action resize = builder.clickAndHold(resizePoint)
                .moveByOffset(x, y)
                .release()
                .build();
        resize.perform();
        return resizePoint;
    }
}
