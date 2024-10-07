package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DeductionPage {
	
	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();
	
	public DeductionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[text()='Add Deduction']")
	WebElement addDeduction;
	
	@FindBy(xpath = "//span[@title='Select date']")
	WebElement selectDate;
	
	public void clickOnAddDeduction() {
		addDeduction.click();
	}
	
	public String toolTipOfSelectDate() {
		return gu.toolTip(driver,selectDate);
	}
	
	
	

}
