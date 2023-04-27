package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabMenuPage {
	
	@FindBy (xpath="//button[text()='Open Menu']")    private WebElement menu;
	@FindBy (xpath="//a[text()='All Items']")         private WebElement allitems;
	@FindBy (xpath="//a[text()='About']")             private WebElement about;
	@FindBy (xpath="//a[@id='logout_sidebar_link']")  private WebElement logout;
	@FindBy (xpath="//a[text()='Reset App State']")   private WebElement resetapp;
	@FindBy (xpath="//button[text()='Close Menu']")   private WebElement close;
	@FindBy (xpath="//div[text()='Swag Labs']")       private WebElement loginpagetext;
	
     public SwagLabMenuPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }
     
     public void clickOnMenuBar()
     {
    	 menu.click();
     }
     
     public void clickOnAllItems()
     {
    	 allitems.click();
     }
     
     public void clickOnAbout()
     {
    	 about.click();
     }
     
     public void clickOnLogOut()
     {
    	 logout.click();
     }
     
     public void clickOnResetAppState()
     {
    	 resetapp.click();
     }
     
     public void clickOnCloseMenu()
     {
    	 close.click();
     }
     public String getLoginPageText()
     {
    	  String logintext=loginpagetext.getText();
    	  return logintext;
     }
     
  }
