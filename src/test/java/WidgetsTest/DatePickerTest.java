package WidgetsTest;

import Common.TestBase;
import Widgets.DatePicker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DatePickerTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("DatePickerTest.class");

    @Tag("Widgets")
    @Tag("DatePicker")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/datepicker.php"})
    public void shouldWalkInCalendar(String url) throws InterruptedException {
        driver.get(url);
        DatePicker datePicker = new DatePicker(driver);
        datePicker.walk();
    }
}

