package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class AutocompletePage {
    WebDriver driver;

    public AutocompletePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchField = By.xpath("//input[@id='search']");
    private By options = By.xpath("//ul[@id='ui-id-1']/li[@class='ui-menu-item']");

    public AutocompletePage fillSearchField(String value) {
        driver.findElement(searchField).sendKeys(value);
        return this;
    }

    public String selectValueFromList() {
        List<WebElement> valuesList = driver.findElements(options);
        printList(valuesList);
        int selectedOption = new Random().nextInt(valuesList.size());
        String textOfSelectedOption = valuesList.get(selectedOption).getText();
        valuesList.get(selectedOption).click();
        return textOfSelectedOption;
    }

    public String getTextFromSearchField() {
        return driver.findElement(searchField).getAttribute("value");
    }

    public void printList(List<WebElement> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getText());
        }
    }
}
