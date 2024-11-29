package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class DashboardTest extends BaseTest {

    @Test
    public void verifyLogoutFunctionality() {
        driver.get("https://opensource-demo.orangehrmlive.com");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // Logout
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.logout();

        // Verify that user is redirected to the login page
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "User did not log out successfully.");
    }
}
