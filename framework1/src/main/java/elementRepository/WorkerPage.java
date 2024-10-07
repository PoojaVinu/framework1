package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class WorkerPage {
	WebDriver driver;

	GeneralUtilities gu=new GeneralUtilities();
	
	public WorkerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Create Worker']")
	WebElement createWorker;
	
	@FindBy(id = "worker-title")
	WebElement titleDropDown;
	
	@FindBy(xpath ="//button[@class='btn btn-primary']")
	WebElement searchButton;
	
	@FindBy(id = "workersearch-last_name")
	WebElement lastName;
	
	public void clickOnCreateWorker() {
		createWorker.click();
	}
	
	public String selectValueFromTitle() {
		return gu.getSelectedValueFromDropDown(titleDropDown,"Mrs");
	}
	
	public String getTextFromSelectButton() {
		return gu.getElementText(searchButton);
	}
	
	public String getFontSizeOfSearchButton() {
		return gu.getStyleProperties(searchButton,"font-size");
	
	}
	
	public String getToolTipFromTable() {
		WebElement updateToolTip=driver.
				findElement(By.xpath("//table[@class='table table-striped table-bordered']//tbody//td[8]//a[2]"));
		return gu.toolTip(driver, updateToolTip);
		
	}
	
	public boolean searchByName(String workerNameToSearch) {
		List<WebElement> nameColumn=driver.
				findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//td[2]"));
		return gu.isTableFilteringWorkingProperly(nameColumn,workerNameToSearch );
	}

}
