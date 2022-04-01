package WidgetsTest;

import Common.TestBase;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TooltipTest extends TestBase {
    private static Logger logger = LoggerFactory.getLogger("TooltipTest.class");
    private By elementWIthTooltip1 = By.xpath("//a[contains(text(), 'Tooltips')]");
    private By elementWIthTooltip2 = By.xpath("//a[contains(text(), 'ThemeRoller')]");
    private By elementWIthTooltip3 = By.xpath("//input[@id='age']");

    @Tag("Widgets")
    @Tag("Tooltips")
    @ParameterizedTest
    @ValueSource(strings = {"https://seleniumui.moderntester.pl/tooltip.php"})
    public void printTooltips(String url){
        driver.get(url);
        String t1 = driver.findElement(elementWIthTooltip1).getAttribute("title");
        System.out.println("1. Tooltip is: "+ t1);

        String t2 = driver.findElement(elementWIthTooltip2).getAttribute("title");
        System.out.println("2. Tooltip is: "+ t2);

        String t3 = driver.findElement(elementWIthTooltip3).getAttribute("title");
        System.out.println("3. Tooltip is: "+ t3);
    }

}
