package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataImportPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(xpath = "//span[normalize-space()='PIM']")
	WebElement PIMButton;
	
	@FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item']")
	WebElement configurationDropDown;
	
	@FindBy(xpath = "//a[normalize-space()='Data Import']")
	WebElement dataImportSelect;
	
	@FindBy(xpath = "//button[normalize-space()='Upload']")
	WebElement uploadFileButton;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--card-body']")
	WebElement confirmMessage;
	
	@FindBy(xpath = "//button[normalize-space()='Ok']")
	WebElement okButton;
	
	By fileUpload = By.xpath("//input[@type='file']");

    public DataImportPage(WebDriver driver) {
    	this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    
    public void NavigateToPIM() throws InterruptedException {
    	WebElement PIMButtonElement = wait.until(ExpectedConditions.elementToBeClickable(PIMButton));
        PIMButtonElement.click();
    }
    
    public void NavigateToDataImport() throws InterruptedException {
    	WebElement configurationDropDownElement = wait.until(ExpectedConditions.elementToBeClickable(configurationDropDown));
        configurationDropDownElement.click();
        
        WebElement dataImportSelectElement = wait.until(ExpectedConditions.elementToBeClickable(dataImportSelect));
        dataImportSelectElement.click();
    }
    
    public void uploadFile(String filePath) throws InterruptedException {
    	WebElement fileInputElement = wait.until(ExpectedConditions.presenceOfElementLocated(fileUpload));
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", fileInputElement);
        fileInputElement.sendKeys(filePath);
        
        WebElement uploadFileButtonElement = wait.until(ExpectedConditions.elementToBeClickable(uploadFileButton));
        uploadFileButtonElement.click();
    }
    
    public String confirmMessage() throws InterruptedException {
    	WebElement confirmMessageElement = wait.until(ExpectedConditions.elementToBeClickable(confirmMessage));
    	String message = confirmMessageElement.getText();
    	
    	WebElement okButtonElement = wait.until(ExpectedConditions.elementToBeClickable(okButton));
    	okButtonElement.click();
    	return message;
    }

}
