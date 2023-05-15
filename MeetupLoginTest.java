package appiumtests;
import base.AppDriver;
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

public class MeetupLoginTest {

    public static AppiumDriver driver;
    public static DesiredCapabilities cap;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("SM-G973F")
                .setPlatformVersion("12.0")
                .setAppPackage("com.meetup")
                .setAppActivity(".feature.legacy.activity.BootstrapActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        AppDriver.setDriver(driver);
        Thread.sleep(1000);

		// Positive testcase
		driver.AppiumBy.accessibilityId("intro_login_link_button").click();
		//loginButton.click();

		driver.AppiumBy.accessibilityId("login_email").sendKeys("test1valid@yahoo.com");
		// MobileElement emailInput = (MobileElement) driver.findElementById("com.meetup:id/login_email");
		// emailInput.sendKeys("test1valid@yahoo.com");

		driver.AppiumBy.accessibilityId("login_password").sendKeys("MyPass_1");
		// MobileElement passwordInput = (MobileElement) driver.findElementById("com.meetup:id/login_password");
		// passwordInput.sendKeys("MyPass_1");

		driver.AppiumBy.accessibilityId("email_login_button").click();
		// MobileElement signInButton = (MobileElement) driver.findElementById("com.meetup:id/email_login_button");
		// signInButton.click();

        Thread.sleep(10000);
        MobileElement succeed = (MobileElement) driver.findElementById("com.meetup:id/upgrade_button");

        // Assert
        String res = succeed.getText();
		if (res == "Welcome!")
			System.out.println("\nTestcase failed"); 	// False positive
		else
			System.out.println("\nTestcase passed");
	
	// ToDo: loguut();	// get prepared for another login attempt
		
	System.out.println("\nEnd of tests");
	driver.quit();

		// try {
		// 		testlogin();
		// 	} catch (Exception e) {
		// 		// TODO Auto-generated catch block
		// 		e.getCause();
		// 		e.getMessage();
		// 		e.printStackTrace();
		// 	}
	}
/* 	public static void testlogin() throws Exception {
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
		
		
	// ToDo: a 10 seconds delay

	// Todo: Handling edge cases where upon a login attempt, google.android pops up 'Password Save' window which needs top be confirmed (perhaps with Never button click)
	// Todo: Handling an edge case where upon a successful login, Meetup pops up a screen asking for rating an attended event or some notification
		
	// When landed at Homepage screen
//        MobileElement succeed = (MobileElement) driver.findElementById("com.meetup:id/upgrade_button");
//        Assert
		String res = succeed.getText();
		if (res == "Welcome!")
			System.out.println("\nTestcase passed");
		else
			System.out.println("\nTestcase failed");

	// ToDo: loguut();	// get prepared for another login attempt
		
// negative testcase
        MobileElement loginButton = (MobileElement) driver.findElementById("com.meetup:id/intro_login_link_button");
        loginButton.click();

        MobileElement emailInput = (MobileElement) driver.findElementById("com.meetup:id/login_email");
        emailInput.sendKeys("test1valid@yahoo.com");

        MobileElement passwordInput = (MobileElement) driver.findElementById("com.meetup:id/login_password");
        passwordInput.sendKeys("MyPass_1_Invalid");

        MobileElement signInButton = (MobileElement) driver.findElementById("com.meetup:id/email_login_button");
        signInButton.click();

	// ToDo: a 10 seconds delay
		

	}
 */
}
