package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy (xpath="//button[text()='Add to cart']")        private List<WebElement >addtocart;
	@FindBy (xpath="//button[text()='Remove']")             private WebElement remove;
	@FindBy (xpath="//a[@class='shopping_cart_link']")      private WebElement cartlink;
	@FindBy (xpath="//span[@class='shopping_cart_badge']")  private WebElement itemquantity;
	@FindBy (xpath="//div[@class='inventory_item_name']")   private List<WebElement>  text;
	@FindBy (xpath="//div[@class='inventory_item_price']")  private List<WebElement> price;
	@FindBy (xpath="//button[@name='continue-shopping']")   private WebElement continueshopping;
	@FindBy (xpath="//span[text()='Your Cart']")            private WebElement yourcart;
	@FindBy (xpath="//button[text()='Checkout']")           private WebElement checkout;
	
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public int clickOnAddToCart(int i)
	{
		 addtocart.get(i).click();
		return i;
	}
	 
	public void clickOnRemove()
	{
		remove.click();
	}
	
	public void clickOnViewCart()
	{
		cartlink.click();
	}
	
	public void getCartProductText()
	
	{
		for(int i = 0 ; i < text.size(); i++)
		System.out.println(text.get(i).getText());
	}
	
	public void getProdctQuantity()
	{
		System.out.println(itemquantity.getText());
	}
	
	public void clickOnContinueShopping()
	{
		continueshopping.click();
	}
	
	public void clickOnCheckout()
	{
		checkout.click();
	}
	
	public String getCartText()
	{
		String text=yourcart.getText();
		return text;
	}
	
	public void getPrice()
	{
		for(int i = 0 ; i < price.size(); i++)
			System.out.println(price.get(i).getText());
	}
}
