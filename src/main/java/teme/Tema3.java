package teme;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Tema3 extends BaseTest {
	
	private String bookTitle = "The story about me";
	
	@Test
	private void checkAddToCart() throws InterruptedException {
		WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
		assertTrue(searchButton.isDisplayed());
		searchButton.click();
		Thread.sleep(1000);
		WebElement input = driver.findElement(By.cssSelector("input[class='search_field']"));
		assertTrue(input.isDisplayed());
		input.sendKeys(bookTitle);
		searchButton.click();
		Thread.sleep(2000);
		List<WebElement> books = driver.findElements(By.cssSelector("div[class*='isotope_item']"));
		int last = 0;
		WebElement viewMore = driver.findElement(By.cssSelector("div[id='viewmore']"));
		Boolean bookFound = false;
		while(!bookFound && viewMore.isDisplayed()) {
			if(last == books.size() && viewMore.isDisplayed()) {
				viewMore.click();
				Thread.sleep(2000);
				books = driver.findElements(By.cssSelector("div[class*='isotope_item']"));
				
			} else {
				WebElement titleBook = books.get(last).findElement(By.cssSelector("a"));
				if(titleBook.getText().equals(bookTitle)) {
					bookFound = true;
					titleBook.click();
					Thread.sleep(2000);
				}
				last++;
			}
		}
		assertTrue(bookFound);
		assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/shop/the-story-about-me/"));
		WebElement addToCart = driver.findElement(By.cssSelector("button[name='add-to-cart']"));
		assertTrue(addToCart.isDisplayed());
		addToCart.click();
		Thread.sleep(1000);
		WebElement text = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
		String added = text.getText();
		assertTrue(added.contains(bookTitle));
		assertTrue(added.contains(" has been added to your cart."));
		WebElement viewCart = text.findElement(By.cssSelector("a[class*='button'"));
		assertTrue(viewCart.isDisplayed());
		viewCart.click();
		Thread.sleep(2000);
		assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/cart/"));	
	}
	
	@Test(dependsOnMethods = {"checkAddToCart"})
	private void checkUpdateAndPlaceOrder() throws InterruptedException {
		WebElement increase = driver.findElement(By.cssSelector("input[title='Qty']"));
		assertTrue(increase.isDisplayed());
		increase.clear();
		increase.sendKeys("2");
		Thread.sleep(1000);
		WebElement updateCart = driver.findElement(By.cssSelector("button[name='update_cart']"));
		updateCart.click();
		Thread.sleep(3000);
		WebElement text = driver.findElement(By.cssSelector("div[class='woocommerce-message']"));
		assertTrue(text.getText().equals("Cart updated."));
		WebElement checkout = driver.findElement(By.cssSelector("a[class*='checkout-button']"));
		checkout.click();
		Thread.sleep(2000);
		assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/checkout/"));
		String billingField = driver.findElement(By.cssSelector("div[class='woocommerce-billing-fields']"))
				.findElement(By.cssSelector("h3")).getText();
		assertTrue(billingField.equals("Billing details"));
		String additionalInformations = driver.findElement(By.cssSelector("div[class='woocommerce-additional-fields']"))
				.findElement(By.cssSelector("h3")).getText();
		assertTrue(additionalInformations.equals("Additional information"));
	}

}
