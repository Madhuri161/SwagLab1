package utility;


	import java.io.File;
	import java.io.IOException;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	public class Screenshot {

		public  static void takescreenshot(WebDriver driver,String name) throws IOException
		{
			String date=DateAndTime.getDateAndTime();
			
			File sourec=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File destination= new File("C:\\Users\\DELL\\Documents\\Eclips\\Naaptol\\Screenshot\\"+name+".png");
			
			FileHandler.copy(sourec, destination);
		}
		
		
}
