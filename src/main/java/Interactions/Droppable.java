package Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Droppable {
    WebDriver driver;

    public Droppable(WebDriver driver) {
        this.driver = driver;
    }
    private By dragElement = By.xpath("//div[@id='draggable']");
    private By dropElement = By.xpath("//div[@id='droppable']");
    private By dragAndDropConfirmationMessage = By.xpath("//div[@id='droppable']/p");

    public void dragAndDropDroppable() {
        WebElement fromElement = driver.findElement(dragElement);
        WebElement toElement = driver.findElement(dropElement);
        Actions action = (new Actions(driver)).dragAndDrop(fromElement, toElement);
        action.perform();
    }

    public String  getDragAndDropConfirmationMessage(){
        return driver.findElement(dragAndDropConfirmationMessage).getText();
    }
}
