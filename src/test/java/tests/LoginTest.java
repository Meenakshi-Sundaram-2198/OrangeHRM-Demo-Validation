package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isWelcomeMessageDisplayed(), "Welcome message is not displayed after login");
    }

    @Test
    public void invalidLoginTest() {
        driver.get("https://opensource-demo.orangehrmlive.com");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("InvalidUser", "InvalidPassword");

        // Assuming an error message appears on invalid login
        Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"), "Error message is not displayed");
    }
}
