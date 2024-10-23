package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseClass{

	@Test
	public void GoogleSearch() throws Exception {
		
		System.out.println("Test case one started");
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Appium");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		System.out.println("Test case one ended");
		
	}
	
	@Test
	public void GoogleSearch2() throws Exception {
		
		System.out.println("Test case two started");
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Automation");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		System.out.println("Test case two ended");
		
	}

}
