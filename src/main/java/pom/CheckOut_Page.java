package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Page {
	@FindBy (xpath="//input[@name='firstName']")                              private WebElement firstname;
	@FindBy (xpath="//input[@name='lastName']")                               private WebElement lastname;
	@FindBy (xpath="//input[@name='postalCode']")                             private WebElement postalcode;
	@FindBy (xpath="//input[@id='continue']")                                 private WebElement continuecheckout;
	@FindBy (xpath="//button[@id='cancel']")                                  private WebElement cancel;
	@FindBy (xpath="//span[text()='Checkout: Your Information']")             private WebElement text;
	@FindBy (xpath="//div[@class='inventory_item_name']")                     private List<WebElement> inventoryname;
	@FindBy (xpath="//div[@class='inventory_item_price']")                    private List<WebElement> price;
	@FindBy (xpath="//div[@class='summary_info_label summary_total_label']")  private WebElement totalprice;
	@FindBy (xpath="//span[text()='Checkout: Overview']")                     private WebElement checkouttext;
	@FindBy (xpath="//button[text()='Finish']")                               private WebElement finish;
	@FindBy (xpath="//button[text()='Back Home']")                            private WebElement backhome;
	@FindBy (xpath="//h2[text()='Thank you for your order!']")                private WebElement endpagetext;
	
   public CheckOut_Page(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void enterFirstName(String name)
   {
	   firstname.sendKeys(name);
   }
   
   public void enterLastName(String last)
   {
	   lastname.sendKeys(last);
   }
   public void eneterPostalCode(String postal)
   {
	   postalcode.sendKeys(postal);
   }
   public void clickOnContinue()
   {
	   continuecheckout.click();
   }
   
   public void clickOnCancel()
   {
	   cancel.click();
   }
    
   public String getPageText()
   {
	  String pagetext= text.getText();
	  return pagetext;
   }
   public void getCartProductText()
	{
		for(int i = 0 ; i < inventoryname.size(); i++)
		System.out.println(inventoryname.get(i).getText());
	}
  
   public void getPrice()
	{
		for(int i = 0 ; i < price.size(); i++)
		System.out.println(price.get(i).getText());
	}
	public void getTotalPrice()
	{
		System.out.println(totalprice.getText());
		
	}
   public String getCheckoutPageText()
   {
	   String text=checkouttext.getText();
	   return text;
   }
   
  public void clickOnFinish()
  {
	  finish.click();
  }
  public void clickOnBackHome()
  {
	  backhome.click();
  }
   public String getEndPageText()
   {
	   String endtext=endpagetext.getText();
	   return endtext;
   }
   
}
