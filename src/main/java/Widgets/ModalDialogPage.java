package Widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModalDialogPage {
    private WebDriver driver;

    public ModalDialogPage(WebDriver driver) {
        this.driver = driver;
    }

    private By createNewUserButton = By.xpath("//button[@id='create-user']");
    private By nameField = By.xpath("//input[@id='name']");
    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By createAccountButton = By.xpath("//button[contains(text(),'Create an account')]");
    private By nameOfNewUser = By.xpath("//table[@id='users']//tbody//tr[last()]/td");
    private By emailOfNewUser = By.xpath("//table[@id='users']//tbody//tr[last()]/td[2]");
    private By passwordOfNewUser = By.xpath("//table[@id='users']//tbody//tr[last()]/td[3]");

    public ModalDialogPage clickCreateNewUserButton(){
        driver.findElement(createNewUserButton).click();
        return this;
    }

    public void fillName(String name){
       WebElement nameF = driver.findElement(nameField);
       nameF.clear();
       nameF.sendKeys(name);
    }
    public void fillEmail(String email){
        WebElement emailF = driver.findElement(emailField);
        emailF.clear();
        emailF.sendKeys(email);
    }
    public void fillPassword(String password){
        WebElement passwordF = driver.findElement(passwordField);
        passwordF.clear();
        passwordF.sendKeys(password);
    }
    public ModalDialogPage clickCreateAccountButton(){
        driver.findElement(createAccountButton).click();
        return this;
    }

    public String getAddedName(){
        return(driver.findElement(nameOfNewUser).getText());
    }
    public String getAddedEmail(){
        return(driver.findElement(emailOfNewUser).getText());
    }
    public String getAddedPassword(){
        return(driver.findElement(passwordOfNewUser).getText());
    }

}
