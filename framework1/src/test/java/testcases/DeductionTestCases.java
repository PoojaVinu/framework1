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
 
  @Test(enabled = false)
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
  
  @Test
  public void verifySaveButtonWithoutMandatoryFields() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  DeductionPage dd=db.clickOnDeduction();
	  dd.clickOnAddDeduction();
	  
	  dd.typeFieldDropDown();
	  dd.enterAmount();
	  dd.selectEffectiveDeductionDate();
	  dd.clickSaveButton();
	  String actualErrorMessageOfWorkerField=dd.getWorkerFieldErrorMessage();
	  System.out.println("Worker field error message :" + actualErrorMessageOfWorkerField);
	  String expectedErrorMessageOfWorkerField="Worker cannot be blank.";
	  Assert.assertEquals(actualErrorMessageOfWorkerField, expectedErrorMessageOfWorkerField, Constant.errorMessageOfText);
	  
	  
  }
  
  @Test(enabled = false)
  public void verifyDeductionIsPresentInTable() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  DeductionPage dd=db.clickOnDeduction();
	  dd.clickOnAddDeduction();
	  
	  String fakeWorkerName=dd.workerName();
	  dd.selectWorkerFromDropDown(fakeWorkerName);
	  dd.typeFieldDropDown();
	  dd.enterAmount();
	  dd.selectEffectiveDeductionDate();
	  dd.clickSaveButton();
	  
  }
}
