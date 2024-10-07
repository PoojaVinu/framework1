package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "loginform-username")
	WebElement userName;
	
	@FindBy(id="loginform-password")
	WebElement passWord;
	
	@FindBy(name = "login-button")
	WebElement loginButton;
	
	public void inputUserName(String username) {
		userName.sendKeys(username);
	}
	
	public void inputPassword(String password) {
		passWord.sendKeys(password);
	}
	
	public DashBoardPage clickLoginButton() {    //page redirect
		loginButton.click();
		return new DashBoardPage(driver);        //object creation for DashBoardPage
	}
	
	public DashBoardPage performLogin(String username,String password) {
		userName.sendKeys(username);
		passWord.sendKeys(password);
		clickLoginButton();
		return new DashBoardPage(driver);
	}

}
