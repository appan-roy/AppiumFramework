package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass extends ExtentReporting{

//	AppiumDriver<MobileElement> driver;
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		try {
		
			DesiredCapabilities cap = new DesiredCapabilities();
		
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
			cap.setCapability(MobileCapabilityType.UDID, "192.168.0.3:5555");
			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			
			driver = new RemoteWebDriver(url, cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
//			driver = new AppiumDriver<MobileElement>(url, cap);
//			driver = new AndroidDriver<MobileElement>(url, cap);
//			driver = new IOSDriver<MobileElement>(url, cap);
			
			System.out.println("The remote browser is up and running");
			
			System.out.println("Test execution started");
		
		} catch (MalformedURLException e) {
			System.out.println("Cause is "+e.getCause());
			System.out.println("Message is "+e.getMessage());
			e.printStackTrace();
		}

	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
		System.out.println("Test execution ended");
		
		System.out.println("The remote browser is closed");

	}
	
}
