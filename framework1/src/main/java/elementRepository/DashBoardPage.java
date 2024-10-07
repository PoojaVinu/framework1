package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashBoardPage {
	WebDriver driver;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	GeneralUtilities gu = new GeneralUtilities();

	@FindBy(xpath = "//h1[text()='Payroll Application']")
	WebElement payrollApplicationHeading;
	
	@FindBy(xpath = "//a[text()='Workers']")
	WebElement worker;
	
	@FindBy(xpath ="//a[@href='/payrollapp/client/index']")
	WebElement client;
	
	@FindBy(xpath = "//a[text()='Deduction']")
	WebElement deduction;
	
	@FindBy(xpath = "//a[text()='TimeSheet']")
	WebElement timeSheet;
	
	@FindBy(xpath = "//a[text()='Payslip']")
	WebElement paySlip;
	
	public String getTextFromHeading() {
		return gu.getElementText(payrollApplicationHeading);
	}

	public WorkerPage clickOnWorker() {
		worker.click();
		return new WorkerPage(driver);
	}

	public ClientPage clickOnClient() {
		client.click();
		return new ClientPage(driver);
	}
	
	public DeductionPage clickOnDeduction() {
		deduction.click();
		return new DeductionPage(driver);
	}
	
	public TimeSheetPage clickOnTimeSheet() {
		timeSheet.click();
		return new TimeSheetPage(driver);
	}
	
	public PaySlipPage clickOnPaySlip() {
		paySlip.click();
		return new PaySlipPage(driver);
	}
	
	
	
	
	
}
