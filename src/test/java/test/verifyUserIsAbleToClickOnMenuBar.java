package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabMenuPage;
import utility.BaseTest;
import utility.Reports;

@Listeners(test.Lisners.class)
public class verifyUserIsAbleToClickOnMenuBar extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	
	public void setUpReports() 
	{
	 reports =Reports.createReports();
	}
	
	@BeforeMethod
	 public void openBrowser()
	 {
		driver=Browser.launchbrowser();
	 }
	
	@Test
	public void userIsAbleToClickOnMenuBar() throws InterruptedException
	{
		LoginWith_Standard_Users loginWith_Standard_Users=new LoginWith_Standard_Users();
		loginWith_Standard_Users.verifyLoginWithStandaredUsers();
		
		Thread.sleep(3000);
		
		SwagLabMenuPage swagLabMenuPage = new SwagLabMenuPage(driver);
		
		swagLabMenuPage.clickOnMenuBar();
		
		Thread.sleep(2000);
		
		swagLabMenuPage.clickOnAllItems();
		
		Thread.sleep(3000);
		
		swagLabMenuPage.clickOnCloseMenu();
		
		Thread.sleep(3000);
		
		swagLabMenuPage.clickOnMenuBar();
		
		 Thread.sleep(3000);
		
		swagLabMenuPage.clickOnLogOut();
		
		String title =swagLabMenuPage.getLoginPageText();
		
		Assert.assertEquals(title, "Swag Labs");
	}
	
	@AfterMethod
	public void getTestResult(ITestResult result) 
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName());
		}
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, result.getName());
		}
		else if (result.getStatus()== ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getName());
		}
	}
	
	@AfterTest
	public void publishReports() 
	{
		reports.flush();
	}
}
