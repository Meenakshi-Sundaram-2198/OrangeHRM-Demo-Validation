package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DataImportPage;
import pages.LoginPage;

public class DataImportTest extends BaseTest {
	
	@Test
	public void verifyDataImportFunctionality() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com");

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");
        
        // Data Import/Upload
        DataImportPage dataImportPage = new DataImportPage(driver);
        dataImportPage.NavigateToPIM();
        dataImportPage.NavigateToDataImport();
        dataImportPage.uploadFile("D:\\Selenium Workspace\\Selenium Screenshot\\importData.csv");
        String message = dataImportPage.confirmMessage();
        Assert.assertTrue(message.equals("No Records Imported"), "Upload failed");
    }

}
