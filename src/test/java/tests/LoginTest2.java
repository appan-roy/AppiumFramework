package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class LoginTest2 extends BaseClass{

	@Test
	public void LoginToOrangeHRM() throws Exception {

		ExtentTest rpt = extent.createTest("Login Test", "Sample login demo test");

		rpt.log(Status.INFO, "Login test started");

		try {
			driver.get("https://opensource-demo.orangehrmlive.com/");
			rpt.log(Status.PASS, "Navigated to Application URL");

			try {
				driver.findElement(By.id("txtUsername")).click();
				driver.findElement(By.id("txtUsername")).clear();
				driver.findElement(By.id("txtUsername")).sendKeys("Admin");
				rpt.log(Status.PASS, "Username is entered");

				try {
					driver.findElement(By.id("txtPassword")).click();
					driver.findElement(By.id("txtPassword")).clear();
					driver.findElement(By.id("txtPassword1")).sendKeys("admin123");		//forcefully failed
					rpt.log(Status.PASS, "Password is entered");

					try {
						driver.findElement(By.id("txtPassword")).sendKeys(Keys.ENTER);
						rpt.log(Status.PASS, "ENTER is hit from keyboard");

						Thread.sleep(10000);

						Assert.assertEquals(driver.getTitle(), "OrangeHRM");
						rpt.log(Status.INFO, "User logged in to the application successfully");

						try {
							driver.findElement(By.id("welcome")).click();
							rpt.log(Status.PASS, "Welcome link is clicked");

							try {
								driver.findElement(By.linkText("Logout")).click();
								rpt.log(Status.PASS, "Logout link is clicked");
								rpt.log(Status.INFO, "User logged out from the application successfully");
							} catch (Exception e) {
								rpt.log(Status.FAIL, "Logout link is not found");
								e.printStackTrace();
							}

						} catch (Exception e) {
							rpt.log(Status.FAIL, "Welcome link is not found");
							e.printStackTrace();
						}

					} catch (Exception e) {
						rpt.log(Status.FAIL, "Unable to hit ENTER from keyboard");
						e.printStackTrace();
					}

				} catch (Exception e) {
					rpt.log(Status.FAIL, "Password text box is not found");
					e.printStackTrace();
				}

			} catch (Exception e) {
				rpt.log(Status.FAIL, "Username text box is not found");
				e.printStackTrace();
			}

		} catch (Exception e) {
			rpt.log(Status.FATAL, "URL is not responding");
			e.printStackTrace();
		}

		rpt.log(Status.INFO, "Login test ended");

	}

}
