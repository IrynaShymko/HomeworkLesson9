package Basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage {
    WebDriver driver;
    public AlertPage(WebDriver driver) {
        this.driver = driver;
    }

    private By simpleAlertButton = By.xpath("//button[@id='simple-alert']");
    private By simpleAlertConfirmationMessage = By.xpath("//p[@id='simple-alert-label']");
    private By promptAlertBoxButton = By.xpath("//button[@id='prompt-alert']");
    private By promptConfirmationMessage = By.xpath("//p[@id ='prompt-label']");
    private By confirmAlertBoxButton = By.xpath("//button[@id ='confirm-alert']");
    private By confirmAlertBoxConfirmationMessage = By.xpath("//p[@id ='confirm-label']");
    private By delayedAlertButton = By.xpath("//button[@id ='delayed-alert']");
    private By delayedAlertConfirmationMessage = By.xpath("//p[@id='delayed-alert-label']");


    public AlertPage acceptSimpleAlertButton() {
        driver.findElement(simpleAlertButton).click();
        driver.switchTo().alert().accept();
        return this;
    }

    public String getSimpleAlertConfirmationMessage() {
        return driver.findElement(simpleAlertConfirmationMessage).getText();
    }

    public AlertPage acceptPromptAlertBox(String dataForPrompt) {
        driver.findElement(promptAlertBoxButton).click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys(dataForPrompt);
        prompt.accept();
        return this;
    }

    public String getPromptConfirmationMessage() {
        return driver.findElement(promptConfirmationMessage).getText();
    }

    public AlertPage acceptConfirmAlertBox() {
        driver.findElement(confirmAlertBoxButton).click();
        driver.switchTo().alert().accept();
        return this;
    }

    public AlertPage dismissConfirmAlertBox() {
        driver.findElement(confirmAlertBoxButton).click();
        driver.switchTo().alert().dismiss();
        return this;
    }

    public String getConfirmAlertBoxConfirmationMessage() {
        return driver.findElement(confirmAlertBoxConfirmationMessage).getText();
    }

    public AlertPage acceptDelayedAlert() {
        driver.findElement(delayedAlertButton).click();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }

    public String getDelayedAlertConfirmationMessage() {
        return driver.findElement(delayedAlertConfirmationMessage).getText();
    }
}
