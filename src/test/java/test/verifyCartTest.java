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
import pom.CartPage;
import utility.BaseTest;
import utility.Reports;

@Listeners(test.Lisners.class)
public class verifyCartTest extends BaseTest{
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
	 @Test(priority=1)
	public void verifyUserIsAbleToAddProductIntoCart() throws InterruptedException
	{
		LoginWith_Standard_Users loginWith_Standard_Users=new LoginWith_Standard_Users();
		loginWith_Standard_Users.verifyLoginWithStandaredUsers();
		
		Thread.sleep(3000);
		
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnAddToCart(2);
		cartPage.clickOnViewCart();
		cartPage.getCartProductText();
		cartPage.getPrice();
		cartPage.getProdctQuantity();
		
		String text=cartPage.getCartText();
		
		Assert.assertEquals(text, "Your Cart");
	}
	 
	 @Test(priority=2)
	 
	 public void verifyUserIsAbleToAddMultipleProducttocart() throws InterruptedException
	 {
		 LoginWith_Standard_Users loginWith_Standard_Users=new LoginWith_Standard_Users();
		 loginWith_Standard_Users.verifyLoginWithStandaredUsers();
		 Thread.sleep(3000);
		 
		 CartPage cartPage=new CartPage(driver);
		 cartPage.clickOnAddToCart(2);
		 
		 Thread.sleep(2500);
		 
		 cartPage.clickOnViewCart();
		 
		 Thread.sleep(2500);
		 
		 cartPage.clickOnContinueShopping();
		 
		 Thread.sleep(2500);
		 
		 cartPage.clickOnAddToCart(4);
		 cartPage.clickOnViewCart();
		 cartPage.getCartProductText();
		 cartPage.getPrice();
		 cartPage.getProdctQuantity();
		 
		 String text=cartPage.getCartText();
		 
		 Assert.assertEquals(text, "Your Cart");
			
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
