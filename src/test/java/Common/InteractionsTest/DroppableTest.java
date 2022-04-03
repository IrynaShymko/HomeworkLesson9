package Common.InteractionsTest;

import Common.TestBase;
import Interactions.Droppable;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class DroppableTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("DroppableTest.class");
    @Tag("Interactions")
    @Tag("Droppable")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/Interactions/DroppableData.csv", delimiter = ';', numLinesToSkip = 1)
    public void shouldMoveSquare(String url, String expectedMessage) {
        driver.get(url);
        Droppable droppable = new Droppable(driver);
        droppable.dragAndDropDroppable();
        assertThat("Incorrect message for droppable", droppable.getDragAndDropConfirmationMessage(), equalTo(expectedMessage));
    }
}
