package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ClientPage {
	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();
	
	public ClientPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[text()='Create Client']")
	WebElement createClient;
	
	@FindBy(id ="client-require_po")
	WebElement requireProCheckBox;
	
	@FindBy(id="clientsearch-client_name")
	WebElement clientNameSearch;
	
	public void clickOnCreateClient() {
		createClient.click();
	}
	
	public void clickOnRequireProCheckBox() {
		requireProCheckBox.click();
	}
	
	public Boolean requireProCheckBoxIsSelected() {
		return gu.checkBoxSelection(requireProCheckBox);
	}
	
	public Boolean searchByClientName(String clientNameToSearch) {
		List<WebElement>clientNames=driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//td[2]"));
		return gu.isTableFilteringWorkingProperly(clientNames, clientNameToSearch);
	}
}
