package test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.SwagLabLoginPage;
import utility.BaseTest;
import utility.Reports;

@Listeners(test.Lisners.class)
public class Loginwith_locked_out_user extends BaseTest{
	
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
	public void verifyLoginWith_locked_out_user( )
	{
		SwagLabLoginPage swagLabLoginPage=new SwagLabLoginPage(driver);
		swagLabLoginPage.enterUsername("locked_out_user");
		swagLabLoginPage.enterPassword("secret_sauce");
		swagLabLoginPage.clickOnLogin();
		
		WebElement error=driver.findElement(By.xpath("//h3[@data-test='error']"));
		String errorforlockedusers=error.getText();
		
		Assert.assertEquals(errorforlockedusers, "Epic sadface: Sorry, this user has been locked out.");
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
