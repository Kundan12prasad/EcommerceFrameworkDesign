package kundanprasadacademy.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import kundanprasadacademy.pageobjects.ProductCatalogue;
import kundanprasadacademy.testcomponent.BaseTest;

public class ErrorValidationTest extends BaseTest {

	@Test(groups={"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";
		landingPage.loginApplication("kundanprasad90@gmail.com", "Login@2000");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	/*List<WebElement> products = productCatalogue.getProductList();
	productCatalogue.addProductToCart(productName);
	CartPage cartPage = productCatalogue.goToCartPage();
	Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
	Assert.assertFalse(match); */

}
