package elementRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.FakerUtility;
import utilities.GeneralUtilities;

public class DeductionPage {
	
	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();
	FakerUtility fu=new FakerUtility();
	
	public DeductionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[text()='Add Deduction']")
	WebElement addDeduction;
	
	@FindBy(xpath = "//span[@title='Select date']")
	WebElement selectDate;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath = "//p[text()='Worker cannot be blank.']")
	WebElement workerFieldErrorMessage;
	
	@FindBy(id="deduction-type")
	WebElement deductionTypeField;
	
	@FindBy(id="deduction-amount")
	WebElement deductionAmountField;
	
	@FindBy(id="deduction-effective_from")
	WebElement deductionEffectiveDate;
	
	@FindBy(xpath = "//span[@class='select2-selection__arrow']")
	WebElement workerDropDown;
	
	public void clickOnAddDeduction() {
		addDeduction.click();
	}
	
	public String toolTipOfSelectDate() {
		return gu.toolTip(driver,selectDate);
	}
	
	public String typeFieldDropDown() {
		return gu.getSelectedValueFromDropDown(deductionTypeField, "Locker Keys");
	}
	
	public void enterAmount() {
		deductionAmountField.sendKeys("2000");
	}
	
	public void selectEffectiveDeductionDate() {
		deductionEffectiveDate.click();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public String getWorkerFieldErrorMessage() {
		return gu.getElementText(workerFieldErrorMessage);
	}
	
	public String workerName() {
		return fu.getFakeFullName();
	}
	
	public void selectWorkerFromDropDown(String workerName) {
		
		workerDropDown.click();
		
		
		
	}
}
	
	

