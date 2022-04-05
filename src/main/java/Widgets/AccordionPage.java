package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccordionPage {
    private WebDriver driver;

    public AccordionPage(WebDriver driver) {
        this.driver = driver;
    }

    private By text1 = By.xpath("//div[@id='ui-id-2']/p");
    private By titleSection2 = By.xpath("//h3[@id='ui-id-3']");
    private By text2 = By.xpath("//div[@id='ui-id-4']/p");
    private By titleSection3 = By.xpath("//h3[@id='ui-id-5']");
    private By text3 = By.xpath("//div[@id='ui-id-6']");
    private By titleSection4 = By.xpath("//h3[@id='ui-id-7']");
    private By text4 = By.xpath("//div[@id='ui-id-8']");

    public String getText1() {
        return driver.findElement(text1).getText();
    }
    public String getText2() {
        return driver.findElement(text2).getText();
    }
    public String getText3() {
        return driver.findElement(text3).getText();
    }
    public String getText4() {
        return driver.findElement(text4).getText();
    }

    public AccordionPage clickTitleSection2(){
        driver.findElement(titleSection2).click();
        return this;
    }
    public AccordionPage clickTitleSection3(){
        driver.findElement(titleSection3).click();
        return this;
    }
    public AccordionPage clickTitleSection4(){
        driver.findElement(titleSection4).click();
        return this;
    }
}
