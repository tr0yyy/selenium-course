package curs2;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utils.BaseTest;

public class FindElementsExample extends BaseTest{
	
	
	@Test
	public void findElementsExample1() throws InterruptedException {
		List<WebElement> booksPictures =  driver.findElements(By.cssSelector("figure[class*='sc_image']"));
		int counter=0;
		for(WebElement picture : booksPictures) {
			counter++;
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red;')", picture);
			Thread.sleep(3000);
			if(counter==5) {
				jse.executeScript("window.scollBy(0, 1500);");
				Actions actions = new Actions(driver);
				actions.moveToElement(booksPictures.get(counter));

			}
			
		}
		
	}
	
	
	@Test(priority=1)
	public void findElementsExample() {
		
		List<WebElement> bookList =  driver.findElements(By.cssSelector("h3[class*='sc_title']"));
		System.out.println(bookList.size());
		bookList.get(2).click();
		
		String expectedUrl = "https://keybooks.ro/shop/life-in-the-garden/";
		assertEquals(driver.getCurrentUrl(), expectedUrl);
		
		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "Life in the garden – Booklovers");
		
	//	<h1 class="product_title entry-title">Life in the garden</h1>
		
		WebElement bookTitle =  driver.findElement(By.cssSelector("h1[class*='product_title']"));
		assertEquals(bookTitle.getText(), "Life in the garden");
		
		
	}

}
