package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepository.ClientPage;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.WorkerPage;
import utilities.ExcelReadUtility;

public class ClientTestCases extends BaseClass{
  @Test
  public void verifyCheckBoxIsSelected() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  ClientPage cp= db.clickOnClient();
	  cp.clickOnCreateClient();
	  cp.clickOnRequireProCheckBox();
	  
	  Boolean actualCheckBoxSelection=cp.requireProCheckBoxIsSelected();
	  System.out.println("Is the check box selected: " + actualCheckBoxSelection);
	  Boolean expectedCheckBoxSelection=true;
	  Assert.assertEquals(actualCheckBoxSelection,expectedCheckBoxSelection,Constant.errorMessageCheckBox);
	  
  }
  @Test
  public void verifyClientNameFromClientSearch() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage db=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  
	  ClientPage cp=db.clickOnClient();
	  
	  Boolean actualClientName=cp.searchByClientName("Sid");
	  System.out.println("Is the client found : " + actualClientName);
	  Boolean expectedClientName=true;
	  Assert.assertEquals(actualClientName, expectedClientName ,Constant.errorMessageOfClientNameFound);
	  
	  
  }
  
}
