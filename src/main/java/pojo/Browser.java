package pojo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	public static WebDriver launchbrowser()
	{
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*"); 
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver(ops);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.saucedemo.com/");
		
		return driver;
	}
	
	
}



