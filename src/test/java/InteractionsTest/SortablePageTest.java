package InteractionsTest;

import Common.TestBase;
import Interactions.SortablePage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SortablePageTest extends TestBase {
    //private static Logger logger = LoggerFactory.getLogger("SortablePageTest.class");
    private Integer[] data = {1, 2, 3, 4, 5, 6, 7};
    private String url = "https://seleniumui.moderntester.pl/sortable.php";
    private By valuesList = By.xpath("//ul[@id='sortable']/li");


    @Tag("Interactions")
    @Tag("Sortable")
    @Test
    public void sort() {
        SortablePage sortablePage = new SortablePage(driver);
        driver.get(url);
        List<Integer> model = sortablePage.shuffleArray(data);
        List<WebElement> elementsList = driver.findElements(valuesList);
        sortablePage.changePosition(model, elementsList);
        assertThat("Order is incorrect", sortablePage.getResultPositions(driver.findElements(valuesList)), equalTo(model));
    }
}