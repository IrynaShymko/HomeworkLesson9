package WidgetsTest;

import Common.TestBase;
import Widgets.SliderPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SliderTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("SliderTest.class");
    Integer[] valuesArray = {50, 80, 80, 20, 0};

    @Tag("Widgets")
    @Tag("Slider")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/slider.php"})
    public void shouldMoveSliderToValues(String url) {
        driver.get(url);
        SliderPage sliderPage = new SliderPage(driver);
        List<Integer> valuesToStop = Arrays.asList(valuesArray);
        List<Integer> resultValuesList = new ArrayList<>();
        sliderPage.moveSliderToValues(valuesToStop, resultValuesList);
        assertThat("Slider values are incorrect", resultValuesList, equalTo(valuesToStop));
    }
}

