package Interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortablePage {
    private WebDriver driver;
    public SortablePage(WebDriver driver) {
        this.driver = driver;
    }
    private By valuesList= By.xpath("//ul[@id='sortable']/li");

    public void changePosition(List<Integer> requiredPositions, List<WebElement> basicElementsList) {
        for (int i = 0; i< requiredPositions.size(); i++) {
            WebElement from = selectElement(basicElementsList,requiredPositions.get(i));
            WebElement to = driver.findElements(valuesList).get(i);
            Actions actions = new Actions(driver);
            actions.dragAndDrop(from, to).perform();
        }
    }
    public WebElement selectElement(List<WebElement> elementsList, Integer value) {
        for (WebElement element : elementsList) {
            if (element.getText().equals("Item "+value)){
                return element;
            }
        }
        return null;
    }
    public List<Integer> getResultPositions(List<WebElement>sortedList){
        List<Integer>resultList = new ArrayList<>();
        for (WebElement element : sortedList) {
            resultList.add(Integer.parseInt(element.getText().substring(5)));
        }return resultList;
    }
    public List<Integer> shuffleArray(Integer [] array){
        List<Integer> intList = Arrays.asList(array);
        Collections.shuffle(intList);
        return intList;
    }
}

