package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.DeductionPage;
import elementRepository.LoginPage;
import utilities.ExcelReadUtility;

public class DeductionTestCases extends BaseClass{
 
  @Test
  public void verifyToolTipOfEffectiveFromInAddDeductionPage() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage dp=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  DeductionPage dd=dp.clickOnDeduction();
	  dd.clickOnAddDeduction();
	  
	  String actualToolTipOfSelectDate=dd.toolTipOfSelectDate();
	  System.out.println("Tool tip of select date for effective from in deduction page :" + actualToolTipOfSelectDate);
	  String expectedToolTipOfSelectDate="Select date";
	  Assert.assertEquals(actualToolTipOfSelectDate, expectedToolTipOfSelectDate,Constant.errorMessageOfToolTip);
	  
  }
}
