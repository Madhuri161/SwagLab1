package test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.Browser;
import pom.CartPage;
import pom.CheckOut_Page;
import utility.BaseTest;
import utility.Reports;

@Listeners(test.Lisners.class)
public class verifyUserIsAbleToChecout extends BaseTest {
	ExtentReports reports;
	ExtentTest test;
	
	@BeforeTest
	
	public void setUpReports() 
	{
	 reports =Reports.createReports();
	}
   
	@BeforeTest
	 
	public void openBrowser()
	{
		driver=Browser.launchbrowser();
	}
	
	@Test
	
	public void userIsAbleToCheckout() throws InterruptedException
	{
		 LoginWith_Standard_Users loginWith_Standard_Users=new LoginWith_Standard_Users();
		 loginWith_Standard_Users.verifyLoginWithStandaredUsers();
		 Thread.sleep(3000);
		 
		 
		 CartPage cartPage=new CartPage(driver);
		 cartPage.clickOnAddToCart(2);
		 cartPage.clickOnViewCart();
		 cartPage.clickOnCheckout();
		 
		 CheckOut_Page checkOut_Page=new CheckOut_Page(driver);
		 
		 String text = checkOut_Page.getPageText();
			
		 Assert.assertEquals(text, "Checkout: Your Information");
			
		 checkOut_Page.enterFirstName("Madhuri");
		 checkOut_Page.enterLastName("Hujare");
		 checkOut_Page.eneterPostalCode("411057");
		 checkOut_Page.clickOnContinue();
		 
		 String title = checkOut_Page.getCheckoutPageText();
			
		 Assert.assertEquals(title, "Checkout: Overview");
		 
		 checkOut_Page.getCartProductText();
		 checkOut_Page.getPrice();
		 checkOut_Page.getTotalPrice();
		 checkOut_Page.clickOnFinish();
		 
		 String endtext = checkOut_Page.getEndPageText();
		 Assert.assertEquals(endtext, "Thank you for your order!");
		 
		 Thread.sleep(2500);
		 
		 checkOut_Page.clickOnBackHome();
		 
		 Thread.sleep(2500);
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
