package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepository.DashBoardPage;
import elementRepository.LoginPage;
import elementRepository.PaySlipPage;
import utilities.ExcelReadUtility;

public class PaySlipTestCases extends BaseClass {
  @Test
  public void verifyNameOfWorkerWithPaySlipID() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  DashBoardPage dp=lp.performLogin(ExcelReadUtility.readStringData(0,1),ExcelReadUtility.readStringData(1,1));
	  PaySlipPage pp=dp.clickOnPaySlip();
	 
	  String actualName=pp.getWorkerNameFromPaySlipsTable("2775");
	  System.out.println("Name of the worker :" + actualName);
	  String expectedName="Ann BabuS";
	  Assert.assertEquals(actualName, expectedName,Constant.errorMessageOfNameOfWorker);
	  
	  
	  
  }
}
