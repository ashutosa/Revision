package com.SeleniumBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyPageTitle {

	@Test
	public void VerifyPageTitle() {

		//Launch Firefox & navigate to Application
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Latest\\DriverClass\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://stackoverflow.com/");

		// Verify Title method1
		String actual_title = driver.getTitle();
		String expected_title = "Stack Overflow - Where Developers Learn, Share, & Build Careers";
		Assert.assertEquals(actual_title, expected_title);

		// Verify Title method2
		Assert.assertTrue(expected_title.contains("Stack Overflow - Where Developers Learn, Share"));

		// Verify Title method3
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains("Stack Overflow - Where Developers Learn,"));

		driver.close();

	}

}
