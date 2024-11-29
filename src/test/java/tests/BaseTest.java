package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.DashboardPage;
import pages.DataImportPage;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
	protected DataImportPage DataImportPage;

    @BeforeMethod
    public void setUp() {
        // Set up the WebDriver path and options
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Workspace\\Chrome Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);

        // Maximize the window
        driver.manage().window().maximize();

        // Initialize Page Objects using PageFactory
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        DataImportPage = PageFactory.initElements(driver, DataImportPage.class);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
