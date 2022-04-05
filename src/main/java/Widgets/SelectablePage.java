package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SelectablePage {
    private WebDriver driver;

    public SelectablePage(WebDriver driver) {
        this.driver = driver;
    }

    private By speedField = By.xpath("//span[@id='speed-button']");
    private By speedValuesOptions = By.xpath("//ul[@id ='speed-menu']/li[@class='ui-menu-item']");

    private By fileField = By.xpath("//span[@id='files-button']");
    private By fileValuesOptions = By.xpath("//li[@class='ui-menu-item']");

    private By numberField = By.xpath("//span[@id='number-button']");
    private By numberValues = By.xpath("//ul[@id='number-menu']/li");

    private By titleField = By.xpath("//span[@id='salutation-button']");
    private By titleValuesOptions = By.xpath("//ul[@id ='salutation-menu']/li[@class='ui-menu-item']");

    public SelectablePage clickSpeedField() {
        driver.findElement(speedField).click();
        return this;
    }

    public SelectablePage clickFileField() {
        driver.findElement(fileField).click();
        return this;
    }

    public SelectablePage clickNumberField() {
        driver.findElement(numberField).click();
        return this;
    }

    public SelectablePage clickTitleField() {
        driver.findElement(titleField).click();
        return this;
    }

    public SelectablePage selectSpeed() {
        clickSpeedField();
        List<WebElement> speedVariants = driver.findElements(speedValuesOptions);
        int index = new Random().nextInt(speedVariants.size());
        speedVariants.get(index).click();
        return this;
    }

    public SelectablePage selectFile(String text) {
        clickFileField();
        List<WebElement> fileVariants = driver.findElements(fileValuesOptions);
        for (WebElement fileVariant : fileVariants) {
            if (fileVariant.getText().equals(text)) {
                fileVariant.click();
            }
        }
        return this;
    }

    public SelectablePage selectNumber(int index) {
        clickNumberField();
        List<WebElement> numbersList = driver.findElements(numberValues);
        numbersList.get(index).click();
        return this;
    }

    public SelectablePage selectTitle() {
        clickTitleField();
        List<WebElement> titleVariants = driver.findElements(titleValuesOptions);
        int index = new Random().nextInt(titleVariants.size());
        titleVariants.get(index).click();
        return this;
    }
}
