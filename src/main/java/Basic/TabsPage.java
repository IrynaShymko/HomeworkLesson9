package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabsPage {
    private WebDriver driver;

    public TabsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By newBrowserWindowButtonBy = By.xpath("//button[@id='newBrowserWindow']");
    private By newMessageWindowButtonBy = By.xpath("//button[@id='newMessageWindow']");
    private By newBrowserTabButtonBy = By.xpath("//button[@id='newBrowserTab']");

    public void clickNewBrowserWindowButton(){
        driver.findElement(newBrowserWindowButtonBy).click();
    }

    public void clickNewMessageWindowButton(){
        driver.findElement(newMessageWindowButtonBy).click();
    }

    public void clickNewBrowserTabButton(){
        driver.findElement(newBrowserTabButtonBy).click();
    }

    public void switchToLasOpenedWindow(){
        for(String windowHandle: driver.getWindowHandles()){
            driver.switchTo().window(windowHandle);
        }
    }
}
