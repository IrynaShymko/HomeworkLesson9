package Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Selectable {
    private WebDriver driver;

    public Selectable(WebDriver driver) {
        this.driver = driver;
    }

    private By row1 = By.xpath("//*[contains(text(), 'Item 1')]");
    private By row3 = By.xpath("//*[contains(text(), 'Item 3')]");
    private By row4 = By.xpath("//*[contains(text(), 'Item 4')]");
    private By message = By.xpath("//p[@id='feedback']");

    public String getMessage() {
        return driver.findElement(message).getText();
    }

    public void clickRows() {
        Actions action = (new Actions(driver));
        action.keyDown(Keys.LEFT_CONTROL).build().perform();
        driver.findElement(row1).click();
        driver.findElement(row3).click();
        driver.findElement(row4).click();
        action.keyUp(Keys.LEFT_CONTROL).build().perform();
    }
}
