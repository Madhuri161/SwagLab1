package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage {
	
	@FindBy (xpath="//input[@name='user-name']")          private WebElement username;
	@FindBy (xpath="//input[@id='password']")             private WebElement password;
	@FindBy (xpath="//input[@id='login-button']")         private WebElement login;
	@FindBy (xpath="//img[@class='inventory_item_img']")  private List<WebElement> image;
	
	public SwagLabLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
    
	public void enterUsername(String name)
	{
		username.sendKeys(name);
	}
	
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clickOnLogin()
	{
		login.click();
	}
	
	public void getImage()
	{
		for (int i=0;i>=image.size();i++)
		image.get(i);
	}
}
