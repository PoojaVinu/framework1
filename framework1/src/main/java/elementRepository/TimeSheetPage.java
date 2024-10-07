package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public void clickOnGenerateInvoice() {
		generateInvoice.click();
	}
	
	public String getAlertWhenClickOnGenerateInvoice() {
		return gu.getAlertMessage(driver,true);
	}
	
	public String getTextOfApproveTimeSheetButton() {
		return gu.getElementText(approveTimesheet);
	}
	
	

}
