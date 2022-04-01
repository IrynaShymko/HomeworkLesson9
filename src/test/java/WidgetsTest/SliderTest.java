package WidgetsTest;

import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SliderTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("SliderTest.class");

    private By sliderElement = By.xpath("//div[@id='custom-handle']");

    @Tag("Widgets")
    @Tag("Slider")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/slider.php"})
    public void moveSlider(String url) {
        driver.get(url);
        WebElement slider = driver.findElement(sliderElement);
        Actions actions = new Actions(driver);
        Action clickAndHold = actions.clickAndHold(slider).build();
        Action moveRight = actions.sendKeys(Keys.ARROW_RIGHT).build();
        Action moveLeft = actions.sendKeys(Keys.ARROW_LEFT).build();

        clickAndHold.perform();
        for(int i=1; i<=50; i++){
            moveRight.perform();
        }
        System.out.println("1. Value on slider is: "+ slider.getText());

        clickAndHold.perform();
        for(int i=50; i<79; i++){
            moveRight.perform();
        }
        System.out.println("2. Value on slider is: "+ slider.getText());

        for(int i=79; i<=80; i++){
            moveRight.perform();
        }
        clickAndHold.perform();
        for(int i=80; i>=78; i--){
            moveLeft.perform();
        }
        System.out.println("3. Value on slider is: "+ slider.getText());

        clickAndHold.perform();
        for(int i=80; i>=20; i--){
            moveLeft.perform();
        }
        System.out.println("4. Value on slider is: "+ slider.getText());
        clickAndHold.perform();
        for(int i=20; i>=0; i--){
            moveLeft.perform();
        }
        System.out.println("5. Value on slider is: "+ slider.getText());

    }
}

