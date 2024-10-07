package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.WorkerPage;
import utilities.ExcelReadUtility;

public class WorkerTestCases extends BaseClass {
 
  @Test(retryAnalyzer =utilities.RetryAnalyzer.class )
  public void verifyTitleDropDown() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  WorkerPage wp=db.clickOnWorker();
	  wp.clickOnCreateWorker();
	  
	  String actualSelectedTitle=wp.selectValueFromTitle();
	  String expectedTitle="Mrs";
	  Assert.assertEquals(actualSelectedTitle, expectedTitle,Constant.errorMessageOfDropDown);
	  
  }
  
  @Test(groups="critical")
  public void verifyTextOfSearchButtonInWorkersPage() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  WorkerPage wp=db.clickOnWorker();
	  
	  String actualTextOfSearchButton=wp.getTextFromSelectButton();
	  System.out.println("The actual text is : " + actualTextOfSearchButton);
	  String expectedTextOfSelectButton="Search";
	  Assert.assertEquals(actualTextOfSearchButton, expectedTextOfSelectButton,Constant.errorMessageOfText);
	  
  }
  
  @Test(groups="critical")
  public void verifyFontSizeOfSearchButton() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  WorkerPage wp=db.clickOnWorker();
	  
	  String actualFontSizeOfSearchButton=wp.getFontSizeOfSearchButton();
	  System.out.println("The actual font size of search button :" + actualFontSizeOfSearchButton);
	  String expectedFontSizeOfSearchButton="14px";
	  Assert.assertEquals(actualFontSizeOfSearchButton, expectedFontSizeOfSearchButton,Constant.errorMessageOfFontSize);
  }
  
  @Test
  public void verifyToolTipFromTableInWorkerPage() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  WorkerPage wp=db.clickOnWorker();
	  
	  String actualToolTip=wp.getToolTipFromTable();
	  System.out.println("Actual ToolTip :" + actualToolTip);
	  String expectedToolTip="Update";
	  Assert.assertEquals(actualToolTip, expectedToolTip,Constant.errorMessageOfToolTip);
	  
 }
  
  @Test
  public void verifyWorkerNameFromWorkerSearch() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  WorkerPage wp=db.clickOnWorker();
	  
	  Boolean actualWorkerName=wp.searchByName("Marina Zirbo");
	  System.out.println("Is the last name present :" + actualWorkerName);
	  Boolean expectedWorkerName=true;
	  Assert.assertEquals(actualWorkerName, expectedWorkerName, Constant.errorMessageOfNameOfWorker);
	  
  }
}
