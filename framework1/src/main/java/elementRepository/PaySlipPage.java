package elementRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class PaySlipPage {
	
	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	public PaySlipPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public String getWorkerNameFromPaySlipsTable(String paySlipIDToSearch) {
		String workerName = "";
		
		List<WebElement> paySlipID = driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//td[1]"));
		int rowNumber = gu.getTableValueDynamically(paySlipID, paySlipIDToSearch);
		
		workerName = "//table[@class='table table-striped table-bordered']//tbody//tr[" + (rowNumber) + "]//td[6]";

		WebElement name = driver.findElement(By.xpath(workerName));
		return gu.getElementText(name);
	}

}
