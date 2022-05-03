package curs2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	//lowerCamelCase
	//UpperCamelCase
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	@Test
	public void loginTest() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement usernameField = driver.findElement(By.id("username"));
		//jse.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:5px solid red;')", usernameField);
		Thread.sleep(4000);
		//jse.executeScript("arguments[0].setAttribute('style', 'display:none;')", usernameField);
		//assertTrue(usernameField.isDisplayed());
		
		//jse.executeScript("arguments[0].setAttribute('disabled', '')", usernameField);
		//assertTrue(usernameField.isEnabled());
		usernameField.click();
		usernameField.sendKeys("tomsmith");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.click();
		passwordField.sendKeys("SuperSecretPassword!");
		
		driver.findElement(By.cssSelector(".fa")).click();
		WebElement sucessMsg = driver.findElement(By.id("flash"));
		assertTrue(sucessMsg.getText().contains("You logged into a secure area!"));
		
		

		
	}
	
	

}
