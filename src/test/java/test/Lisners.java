package test;


	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

import utility.BaseTest;
import utility.Screenshot;

	public class Lisners extends BaseTest implements ITestListener {
		
		public void onTestStart(ITestResult result) {
			System.out.println("Test Started :-"+ result.getName());
		}
		
		public void onTestFailure(ITestResult result) {
			
			try 
			{
				Screenshot.takescreenshot(driver, result.getName());
			} 
			
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		
		public void onTestSuccess(ITestResult result) {
			System.out.println("Test Passed :- "+ result.getName());
		}
		
		public void onTestSkipped(ITestResult result) {
			System.out.println("Test Skipped :-"+ result.getName());
		}
		
		
	}



