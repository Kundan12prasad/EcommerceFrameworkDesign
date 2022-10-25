package kundanprasadacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import kundanprasadacademy.pageobjects.CartPage;
import kundanprasadacademy.pageobjects.CheckoutPage;
import kundanprasadacademy.pageobjects.ConfirmationPage;
import kundanprasadacademy.pageobjects.LandingPage;
import kundanprasadacademy.pageobjects.OrderPage;
import kundanprasadacademy.pageobjects.ProductCatalogue;
import kundanprasadacademy.testcomponent.BaseTest;
import kundanprasadacademy.testcomponent.Retry;

public class SubmitOrderTest extends BaseTest {
   
	String productName= "ZARA COAT 3";
	@Test(dataProvider="getData", groups={"Purchase"}, retryAnalyzer=Retry.class)
	//public void submitOrder(String email, String password,String productName ) throws InterruptedException, IOException {
					
		public void submitOrder(HashMap<String,String> input ) throws InterruptedException, IOException
		{
		//LandingPage landingPage=launchApplication();		
		//LandingPage landingPage=new LandingPage(driver);
		
		ProductCatalogue productCatalogue= landingPage.loginApplication(input.get("email"),input.get("password"));	
		
		//ProductCatalogue productCatalogue=new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));	
		CartPage cartPage = productCatalogue.goToCartPage();
		//CartPage cartPage = new CartPage(driver);	
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage ConfirmationPage = checkoutPage.submitOrder();
		String confirmMessage = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		//driver.close();			
	}	
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest()
	{
		//"ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("kundnprasad29@gmail.com", "Learning@2000");
		OrderPage orderPage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));		
    }
	
	//providing data with the help of HashMap
	
	@DataProvider 
	 public Object[][] getData() throws IOException 
	 {
		/*HashMap<String,String> map1 = new HashMap<String,String>();
	    map1.put("email", "kundanprasad29@gmail.com");
		map1.put("password", "Learning@2000");
		map1.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map2 = new HashMap<String,String>();
		map2.put("email", "kundanprasad03@gmail.com");
		map2.put("password", "Learning@4000");
		map2.put("product", "ADIDAS ORIGINAL"); */
		
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")
				+"\\src\\test\\java\\kundanprasadacademy\\data\\PurchaseOrder.json"
				);		
		return new Object[][] { {data.get(0)},{data.get(1)} };
		
	 }	
	
	
	/*
	 * @DataProvider 
	 * public Object[][] getData() 
	 * { return new Object[][] 
	 * {	 * 
	 * {"kundanprasad29@gmail.com","Learning@2000","ZARA COAT 3"},
	 * {"kundanprasad03@gmail.com","Learning@4000","ADIDAS ORIGINAL" } 
	 * };
	 * 
	 */
	
	
	
	
	
	
}






     // driver.get("https://rahulshettyacademy.com/client");
		/*
		 * WebElement userEmail =
		 * driver.findElement(By.xpath("//input[@id='userEmail']"));
		 * userEmail.sendKeys("kundanprasad29@gmail.com"); WebElement userPassword =
		 * driver.findElement(By.id("userPassword"));
		 * userPassword.sendKeys("Learning@2000");
		 * driver.findElement(By.id("login")).click()
		 */;

		/*
		 * WebElement item =
		 * products.stream().filter(product->product.findElement(By.cssSelector("b"))
		 * .getText().equals(productName)).findFirst().orElse(null);
		 * item.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		 * 
		 * //Product added to cart successfully:
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * "#toast-container")));
		 * 
		 * //ng animating: wait until animating icon disappear
		 * wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.
		 * cssSelector(".ng-animating"))));
		 */

		/*
		 * driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).
		 * click();
		 * 
		 * List <WebElement> cartProducts =
		 * driver.findElements(By.cssSelector(".cartSection h3")); boolean match =
		 * cartProducts.stream().anyMatch(cartProduct->
		 * cartProduct.getText().equalsIgnoreCase(productName));
		 * 
		 * driver.findElement(By.cssSelector(".totalRow button")).click(); Actions a =
		 * new Actions(driver);
		 * a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']"
		 * )), "india").build().perform();
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
		 * ".ta-results")));
		 * driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).
		 * click(); driver.findElement(By.cssSelector(".action__submit")).click();
		 * String confirmMessage =
		 * driver.findElement(By.cssSelector(".hero-primary")).getText();
		 * Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."))
		 * ; driver.close();
		 */		

	