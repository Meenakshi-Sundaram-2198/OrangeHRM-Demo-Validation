package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators using @FindBy annotation
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement welcomeMessage;

    @FindBy(linkText = "Logout")
    WebElement logoutButton;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Initialize the WebElements using PageFactory
        PageFactory.initElements(driver, this);
    }

    public boolean isWelcomeMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        return welcomeMessage.isDisplayed();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(welcomeMessage));
        welcomeMessage.click();

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
    }
}
