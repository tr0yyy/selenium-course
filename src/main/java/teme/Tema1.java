package teme;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class Tema1 extends BaseTest{
	
	@Test
	private void homeWork() throws InterruptedException {
		WebElement loginButton = driver.findElement(
				By.xpath("//li[@class='menu_user_login']//a[text()='Login']"));
		assertTrue(loginButton.isDisplayed());
		loginButton.click();
		Thread.sleep(2000);
		WebElement userInput = driver.findElement(
				By.xpath("//div[@style='display: block;']//form[contains(@class,'login_form')]//input[@placeholder='Login or Email']"));
		WebElement passwordInput = driver.findElement(
				By.xpath("//div[@style='display: block;']//form[contains(@class,'login_form')]//input[@placeholder='Password']"));
		assertTrue(userInput.isDisplayed());
		assertTrue(passwordInput.isDisplayed());
	}

}
