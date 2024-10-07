package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.TimeSheetPage;
import utilities.ExcelReadUtility;

public class TimeSheetTestCases extends BaseClass {
  @Test
  public void verifyAlertBoxMessageWhenClickOnGenerateInvoice() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage dp=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  TimeSheetPage tp=dp.clickOnTimeSheet();
	  tp.clickOnGenerateInvoice();
	  
	  String actualAlertMessageOfGenerateInvoice=tp.getAlertWhenClickOnGenerateInvoice();
	  System.out.println("Alert message of generate invoice :" + actualAlertMessageOfGenerateInvoice);
	  String expectedAlertMessageofGenerateInvoice="Are you sure you want to generate invoice?";
	  Assert.assertEquals(actualAlertMessageOfGenerateInvoice, expectedAlertMessageofGenerateInvoice,Constant.errorMessageOfAlertBox);
  }
  
  @Test
  public void verifyTextOfApproveTimeSheet() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  TimeSheetPage tp=db.clickOnTimeSheet();
	  
	  String actualTextOfApproveButton=tp.getTextOfApproveTimeSheetButton();
	  System.out.println("Approve Button :" + actualTextOfApproveButton);
	  String expectedTextOfApproveButton="Approve Timesheets";
	  Assert.assertEquals(actualTextOfApproveButton, expectedTextOfApproveButton,Constant.errorMessageOfApproveTimeSheetButton);
  }
}
