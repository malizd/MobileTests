package appiumtests;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.net.*;		// for URL
import java.util.List;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalculatorTest {

	//WebDriver driver;		// for web browser test
	static AppiumDriver driver;
	//AndroidDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				testlogin();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.getCause();
				e.getMessage();
				e.printStackTrace();
			}
	}
	public static void testlogin() throws Exception {
		//deviceName, udid, 
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "SM-G973F");
		cap.setCapability("udid", "RF8M32JZ7VP");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion","12");
		cap.setCapability("appPackage", "com.meetup");
		cap.setCapability("appActivity", "com.meetup.feature.legacy.activity.BootstrapActivity");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		driver = new AppiumDriver(url,cap);
		System.out.println("Meetup App test started...");
		
    // Disclaimer: Appium inspector did not connect to my phone device so element ids are not exact and test would not run
    
// POsitive testcase		
        MobileElement loginButton = (MobileElement) driver.findElementById("com.meetup:id/intro_login_link_button");
        loginButton.click();

        MobileElement emailInput = (MobileElement) driver.findElementById("com.meetup:id/login_email");
        emailInput.sendKeys("test1valid@yahoo.com");

        MobileElement passwordInput = (MobileElement) driver.findElementById("com.meetup:id/login_password");
        passwordInput.sendKeys("MyPass_1");

        MobileElement signInButton = (MobileElement) driver.findElementById("com.meetup:id/email_login_button");
        signInButton.click();

        MobileElement succeed = (MobileElement) driver.findElementById("com.meetup:id/upgrade_button");
//        Assert
		String res = succeed.getText();
		if (res == "Welcome!")
			System.out.println("\nTestcase passed");
		else
			System.out.println("\nTestcase failed");

// negative testcase
        MobileElement loginButton = (MobileElement) driver.findElementById("com.meetup:id/intro_login_link_button");
        loginButton.click();

        MobileElement emailInput = (MobileElement) driver.findElementById("com.meetup:id/login_email");
        emailInput.sendKeys("test1valid@yahoo.com");

        MobileElement passwordInput = (MobileElement) driver.findElementById("com.meetup:id/login_password");
        passwordInput.sendKeys("MyPass_1_Invalid");

        MobileElement signInButton = (MobileElement) driver.findElementById("com.meetup:id/email_login_button");
        signInButton.click();

        MobileElement succeed = (MobileElement) driver.findElementById("com.meetup:id/upgrade_button");

        // Assert
        String res = succeed.getText();
		if (res == "Welcome!")
			System.out.println("\nTestcase failed");
		else
			System.out.println("\nTestcase passed");
		
	
		System.out.println("\nEnd of tests");

	}
}

