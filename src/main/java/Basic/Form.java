package Basic;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import java.util.Random;

public class Form {
    WebDriver driver;
    public Form(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameField = By.xpath("//input [@id='inputFirstName3']");
    private By lastNameField = By.xpath("//input [@id='inputLastName3']");
    private By emailField = By.xpath("//input [@id='inputEmail3']");
    private By sexRadioButtons = By.xpath("//input[@name='gridRadiosSex']");
    private By ageField = By.xpath("//input[@id='inputAge3']");
    private By yearsOfExperience = By.xpath("//input[@name='gridRadiosExperience']");
    private By profession = By.xpath("//*[@for='gridCheckAutomationTester']");
    private By continentField = By.xpath("//select[@id='selectContinents']");
    private By continentsList = By.xpath("//select[@id='selectContinents']//option");
    private By seleniumCommandsField = By.xpath("//select[@id='selectSeleniumCommands']");
    private By uploadFileField = By.xpath("//input[@id= 'chooseFile']");
    private By signInButton = By.xpath("//button[contains(text(), 'Sign in')]");
    private By validationMessage = By.xpath("//div[@id='validator-message']");


    public Form fillFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
        return this;
    }

    public Form fillLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public Form fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public Form checkSexRadioButton() {
        List<WebElement> sexRadioButtonsList = driver.findElements(sexRadioButtons);
        if (sexRadioButtonsList.size() > 0) {
            sexRadioButtonsList.get(new Random().nextInt(sexRadioButtonsList.size())).click();
            return this;
        }
        return this;
    }

    public Form fillAge() {
        WebElement age = driver.findElement(ageField);
        int generatedAge = new Random().nextInt(100);
        for (int i = 0; i <= generatedAge; i++) {
            age.sendKeys(Keys.ARROW_UP);
        }
        return this;
    }

    public Form checkYearOfExperienceRadioButton() {
        List<WebElement> yearOfExperienceRadioButtonsList = driver.findElements(yearsOfExperience);
        if (yearOfExperienceRadioButtonsList.size() > 0) {
            yearOfExperienceRadioButtonsList.get(new Random().nextInt(yearOfExperienceRadioButtonsList.size())).click();
            return this;
        }
        return this;
    }

    public Form checkProfession() {
        driver.findElement(profession).click();
        return this;
    }

    public Form selectContinent() {
        List<WebElement> continents = driver.findElements(continentsList);
        int index = (int) (Math.random() * (continents.size() - 1)) + 1;
        Select drpDwnContinents = new Select(driver.findElement(continentField));
        drpDwnContinents.selectByIndex(index);
        return this;
    }

    public Form selectSeleniumCommands(String command1, String command2) {
        Select drpDwnSeleniumCommands = new Select(driver.findElement(seleniumCommandsField));
        Actions action = new Actions(driver);
        action.keyDown(Keys.LEFT_SHIFT);
        drpDwnSeleniumCommands.selectByVisibleText(command1);
        drpDwnSeleniumCommands.selectByVisibleText(command2);
        action.keyUp(Keys.LEFT_SHIFT);
        return this;
    }

    public Form uploadFile(File file) {
        driver.findElement(uploadFileField).sendKeys(file.getAbsolutePath());
        return this;
    }

    public Form clickSignInButton() {
        driver.findElement(signInButton).click();
        return this;
    }

    public String getValidationMessage() {
        return driver.findElement(validationMessage).getText();
    }

    public Form fillForm(String firstName, String lastName, String email, String command1, String command2, File file) {
        fillFirstName(firstName)
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .checkSexRadioButton()
                .fillAge()
                .checkYearOfExperienceRadioButton()
                .checkProfession()
                .selectContinent()
                .selectSeleniumCommands(command1, command2)
                .uploadFile(file);
        return this;
    }

}