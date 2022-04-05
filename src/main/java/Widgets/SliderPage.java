package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class SliderPage {
    private WebDriver driver;

    public SliderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By sliderHandler = By.xpath("//div[@id='custom-handle']");

    public List<Integer> moveSliderToValues(List<Integer> valuesToStop, List<Integer> resultValuesList) {
        WebElement sliderHandlerElement = driver.findElement(sliderHandler);
        Actions actions = new Actions(driver);
        Action clickAndHold = actions.clickAndHold(sliderHandlerElement).build();

        clickAndHold.perform();
        for (Integer value : valuesToStop) {
            int currentValue = Integer.parseInt(driver.findElement(sliderHandler).getText());
            int howMuchStepsNeedDo = value - currentValue;

            if (howMuchStepsNeedDo > 0) {
                for (int i = 0; i < howMuchStepsNeedDo; i++) {
                    sliderHandlerElement.sendKeys(Keys.ARROW_RIGHT);
                }
            }
            if (howMuchStepsNeedDo < 0) {
                for (int i = 0; i < Math.abs(howMuchStepsNeedDo); i++) {
                    sliderHandlerElement.sendKeys(Keys.ARROW_LEFT);
                }
            }
            resultValuesList.add(Integer.parseInt(sliderHandlerElement.getText()));
            System.out.println("Value on slider is: " + sliderHandlerElement.getText());
        }
        return resultValuesList;
    }
}
