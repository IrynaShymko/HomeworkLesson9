package BasicTest;

import Basic.Form;
import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormTest extends TestBase {
   private static Logger logger = LoggerFactory.getLogger("FormTest.class");
    File fileForUpload = new File("src/main/resources/BasicData/fileForUpload.txt");

    @Tag("Basic")
    @Tag("Form")
    @ParameterizedTest
    @CsvFileSource(files = "src/main/resources/BasicData/fillingFormData.csv", delimiter = ';')
    public void shouldShowSuccessValidationMessage(String url, String firstName, String lastName, String email, String command1, String command2, String message) {
        driver.get(url);
        Form form = new Form(driver);
        form.fillForm(firstName, lastName, email, command1, command2, fileForUpload);
        form.clickSignInButton();
        assertThat("Validation message is incorrect", form.getValidationMessage(), equalTo(message));
    }
}
