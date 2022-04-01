package Common;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DataProviders {
    private static Stream<Arguments> setNewUser() {
        return Stream.of(
                Arguments.of("https://seleniumui.moderntester.pl/modal-dialog.php", "Jack", "j@jackson.com", "jjack1")
        );
    }
}