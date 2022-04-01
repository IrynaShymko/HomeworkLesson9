package Basic;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class IframePage {
    WebDriver driver;
    File screenshot;
    public IframePage(WebDriver driver) {
        this.driver = driver;
    }

    private By iframe1 = By.xpath("//iframe[@name='iframe1']");
    private By iframe2 = By.xpath("//iframe[@name='iframe2']");
    private By iframe1FirstNameField = By.xpath("//input[@id='inputFirstName3']");
    private By iframe1SurnameField = By.xpath("//input[@id='inputSurname3']");
    private By iframe2LoginField = By.xpath("//input[@id='inputLogin']");
    private By iframe2PasswordField = By.xpath("//input[@id='inputPassword']");
    private By iframe2ContinentField = By.xpath("//select[@id='inlineFormCustomSelectPref']");
    private By continentsList = By.xpath("//select[@id='inlineFormCustomSelectPref']/option");
    private By iframe2yearsOfExperienceRadioButtons = By.xpath("//input[@name='gridRadios']");
    private By iframePageBasicDropdown = By.xpath("//li[@class='nav-ite dropdown']");

    public IframePage fillFirstNameIframe1(String firstName) {
        driver.findElement(iframe1FirstNameField).sendKeys(firstName);
        return this;
    }

    public IframePage fillSurNameIframe1(String surname) {
        driver.findElement(iframe1SurnameField).sendKeys(surname);
        return this;
    }

    public IframePage fillIframe1(String firstName, String surname) {
        WebElement IF1 = driver.findElement(iframe1);
        driver.switchTo().frame(IF1);
        fillFirstNameIframe1(firstName);
        fillSurNameIframe1(surname);
        driver.switchTo().defaultContent();
        return this;
    }

    public IframePage fillLoginFieldIframe2(String login) {
        driver.findElement(iframe2LoginField).sendKeys(login);
        return this;
    }

    public IframePage fillPasswordFieldIframe2(String password) {
        driver.findElement(iframe2PasswordField).sendKeys(password);
        return this;
    }

    public IframePage selectContinent() {
        List<WebElement> continents = driver.findElements(continentsList);
        int index = (int) (Math.random() * (continents.size() - 1)) + 1;
        Select drpDwnContinents = new Select(driver.findElement(iframe2ContinentField));
        drpDwnContinents.selectByIndex(index);
        return this;
    }

    public IframePage checkYearOfExperienceRadioButton() {
        List<WebElement> yearOfExperienceRadioButtonsList = driver.findElements(iframe2yearsOfExperienceRadioButtons);
        if (yearOfExperienceRadioButtonsList.size() > 0) {
            yearOfExperienceRadioButtonsList.get(new Random().nextInt(yearOfExperienceRadioButtonsList.size())).click();
            return this;
        }
        return this;
    }

    public IframePage fillIframe2(String login, String password) {
        driver.switchTo().frame(driver.findElement(iframe2));
        fillLoginFieldIframe2(login)
                .fillPasswordFieldIframe2(password)
                .selectContinent()
                .checkYearOfExperienceRadioButton();
        driver.switchTo().defaultContent();
        return this;
    }

    public IframePage clickBasicMenuDropdown() {
        driver.findElement(iframePageBasicDropdown).click();
        return this;
    }

    public void takeScreenshot() {
        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh-mm-ss dd-MM-yyyy");
        String filename = format.format(dateNow) + ".png";
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("src/test/screenshots" + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
