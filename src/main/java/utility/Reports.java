package utility;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports {

	public static ExtentReports createReports() {
		
		ExtentSparkReporter htmlReports = new ExtentSparkReporter("SwagLabTestResult.html");
		ExtentReports reports = new ExtentReports();
		reports.attachReporter(htmlReports);
		reports.setSystemInfo("TestedBy", "Madhuri Hujare");
		reports.setSystemInfo("TestType", "Regression");
		return reports;

	}
	
}
