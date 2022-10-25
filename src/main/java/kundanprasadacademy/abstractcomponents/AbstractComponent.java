package kundanprasadacademy.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import kundanprasadacademy.pageobjects.CartPage;
import kundanprasadacademy.pageobjects.OrderPage;

public class AbstractComponent {
	
	WebDriver driver;	
	public AbstractComponent(WebDriver driver) 
	{
		this.driver=driver;	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;
	
	
	

	public void waitElementToBeAppear(By findBy)
	{
		//
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));	
		
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
	public void waitForWebElementToDisappear(WebElement ele) {
        
		//ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))))
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}	
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage(driver);		
		return cartPage;
		
	}
	
	public OrderPage goToOrderPage()
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);		
		return orderPage;
		
	}
	

}
