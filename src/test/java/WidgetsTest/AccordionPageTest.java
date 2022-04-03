package WidgetsTest;

import Common.TestBase;
import Widgets.AccordionPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccordionPageTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("AccordionPageTest.class");

    @Tag("Basic")
    @Tag("Accordion")
    @ParameterizedTest
    @ValueSource(strings ="https://seleniumui.moderntester.pl/accordion.php")
    public void printTextFromAccordion(String url) throws InterruptedException {
        driver.get(url);
        AccordionPage accordionPage = new AccordionPage(driver);
        System.out.println(accordionPage.getText1());
        accordionPage.clickTitleSection2();
        System.out.println(accordionPage.getText2());
        accordionPage.clickTitleSection3();
        Thread.sleep(2000);
        System.out.println(accordionPage.getText3());
        accordionPage.clickTitleSection4();
        Thread.sleep(2000);
        System.out.println(accordionPage.getText4());
    }
}
