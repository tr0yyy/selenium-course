package teme;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Tema2  extends BaseTest {

	@Test
	private void tema() throws InterruptedException {
		List<WebElement> tabList = driver.findElements(
				By.xpath("//li[contains(@class,'sc_tabs_title')]"));
		for(int i = 0 ; i < tabList.size() ; i++) {
			assertTrue(tabList.get(i).isDisplayed());
			tabList.get(i).click();
			Thread.sleep(1500);
			WebElement book = driver.findElement(
					By.xpath("//div[@role='tabpanel' and @style='display: block;']//a[@href='the-forest']"));
			assertTrue(book.isDisplayed());
			if(i == tabList.size() - 1) {
				book.click();
				Thread.sleep(3000);
				assertTrue(driver.getCurrentUrl().equals("https://keybooks.ro/shop/the-forest/"));	
			}
			
		}
		
	}
	
}
