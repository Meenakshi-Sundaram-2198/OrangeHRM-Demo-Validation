package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators using PageFactory
    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    // Constructor to initialize the WebDriver and PageFactory elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Setting a 10-second wait
        PageFactory.initElements(driver, this); // Initialize the elements using PageFactory
    }

    // Method to perform login action
    public void login(String username, String password) {
        // Wait for username field to be visible and then enter text
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameElement.sendKeys(username);

        // Wait for password field to be visible and then enter text
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordElement.sendKeys(password);

        // Wait for login button to be clickable and then click
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }
}
