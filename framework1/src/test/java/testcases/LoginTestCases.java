package testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import utilities.ExcelReadUtility;

public class LoginTestCases extends BaseClass {
	@Test
	public void verifyLoginWithValidUser() throws IOException {
		LoginPage lp = new LoginPage(driver);
		DashBoardPage db =lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
 
		String actual = db.getTextFromHeading();

		String expected = "PAYROLL APPLICATION";
		Assert.assertEquals(actual, expected, "Login feature is not working");
	}
}                                                   
