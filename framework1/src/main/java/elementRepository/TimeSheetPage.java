package elementRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class TimeSheetPage {
	
	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();
	
	public TimeSheetPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//button[text()='Generate Invoice']")
	WebElement generateInvoice;
	
	@FindBy(xpath = "//button[text()='Approve Timesheets']")
	WebElement approveTimesheet;
	
	@FindBy(xpath = "//a[text()='Create Timesheet']")
	WebElement createTimesheet;
	
	@FindBy(xpath = "//div[@class='btn btn-primary btn-file']")
	WebElement browseButton;
	
	@FindBy(xpath = "//button[@title='Upload selected files']")
	WebElement uploadButton;
	
	@FindBy(xpath = "//h1[text()='Create Timesheet']")
	WebElement createTimeSheetHeading;
	
	public void clickOnGenerateInvoice() {
		generateInvoice.click();
	}
	
	public String getAlertWhenClickOnGenerateInvoice() {
		return gu.getAlertMessage(driver,true);
	}
	
	public String getTextOfApproveTimeSheetButton() {
		return gu.getElementText(approveTimesheet);
	}
	
	public void clickOnCreateTimesheet() {
		createTimesheet.click();
	}
	
	public void browseAFileAndUpload() throws InterruptedException {
		
		Actions action=new Actions(driver);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		action.click(browseButton).perform();
		
		Thread.sleep(5000);
		
		
		gu.FileUploadUtility(driver, "\\src\\main\\resources\\Lotus_Photo.jpg",uploadButton);
	}
	
	public String getTextFromCreateTimeSheetPage() {
		return gu.getElementText(createTimeSheetHeading); 
	}
	
	
	
	
	

}
