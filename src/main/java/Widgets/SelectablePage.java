package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


import java.util.List;
import java.util.Random;

public class SelectablePage {
    WebDriver driver;

    public SelectablePage(WebDriver driver) {
        this.driver = driver;
    }

    private By speedField = By.xpath("//span[@id='speed-button']");
    private By speedValuesSelect = By.xpath("//select[@id='speed']");
    private By speedValuesOptions = By.xpath("//select[@id='speed']/option");

    private By fileField = By.xpath("//span[@id='files-button']");
    private By fileValuesSelect = By.xpath("//select[@id='files']");
    private By fileValuesOptions = By.xpath("//select[@name='files']//option");

    private By numberField = By.xpath("//span[@id='number-button']");
    private By numberValuesSelect = By.xpath("//select[@id='number']");

    private By titleField = By.xpath("//span[@id='salutation-button']");
    private By titleValuesSelect = By.xpath("//select[@id='salutation']");
    private By titleValuesOptions = By.xpath("//select[@id='salutation']/option");

    public SelectablePage clickSpeedField() {
        driver.findElement(speedField).click();
        return this;
    }

    public SelectablePage selectSpeed() {
        clickSpeedField();
        List<WebElement> speedVariants = driver.findElements(speedValuesOptions);
        int index = new Random().nextInt(speedVariants.size());
        Actions actions = new Actions(driver);
        for (int i = 0; i <= index; i++) {
            actions.sendKeys(Keys.ARROW_UP).build().perform();
        }
        actions.sendKeys(Keys.ENTER).build().perform();
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


//___________________________________ vyshe linii metody rabotajut______________

    public SelectablePage selectFile(String text) {
        clickFileField();
//        Select valuesOfFile = new Select(driver.findElement(fileValuesSelect));
//        valuesOfFile.selectByVisibleText(text);
        List<WebElement> fileVariants = driver.findElements(fileValuesOptions);
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + text + "')]"));
        actions.moveToElement(element).build().perform();
        actions.sendKeys(Keys.ENTER).build().perform();
//            actions.sendKeys(Keys.ARROW_DOWN).build().perform();
        return this;
    }

    //    public SelectablePage selectNumber (int index){
//        WebDriverWait wait = new WebDriverWait(driver, 12);
//        Select valuesOfNumbers = new Select(driver.findElement(numberValuesSelect));
//        valuesOfNumbers.selectByIndex(index);
//        return this;
//    }
//
//    public SelectablePage selectTitle()  {
//        clickTitleField();

//        Select valuesOfTitle = new Select(driver.findElement(titleValuesSelect));
//        List<WebElement> titleVariants = driver.findElements(titleValuesOptions);
//        int index = new Random().nextInt(titleVariants.size());
//        Actions actions = new Actions(driver);

//        for (int i = 0; i <= index; i++) {
//            actions.sendKeys(Keys.ARROW_UP).build().perform();
//        }
//        actions.sendKeys(Keys.ENTER).build().perform();
////        valuesOfTitle.selectByIndex(new Random().nextInt(titleVariants.size()));
//        return this;
    }

