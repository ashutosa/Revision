package com.SeleniumBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HandleCheckBoxes {

	@Test
	public void checkBoxHandle() throws Exception {

		
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium Latest\\DriverClass\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ironspider.ca/forms/checkradio.htm");

		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@name='color']"));

		for (int i = 1; i < checkboxes.size(); i++) {
			WebElement checkbox = checkboxes.get(i);

			String text = checkbox.getText();
			String attribute = checkbox.getAttribute("innerHTML");
			System.out.println(attribute);

			boolean displayed = checkbox.isDisplayed();
			System.out.println(i + "Checkbox Displayed?" + displayed);

			boolean enabled = checkbox.isEnabled();
			System.out.println(i + "Checkbox Enabled?" + enabled);

			boolean selected = checkbox.isSelected();
			System.out.println(i + "Checkbox Selected?" + selected);

			System.out.println(text);

			if (checkbox.getText().equalsIgnoreCase("Blue") || checkbox.getText().equalsIgnoreCase("Green")) {

				Thread.sleep(3000);
				checkbox.click();
				System.out.println("Checkbox Selected");
				Thread.sleep(3000);

			}

		}
		driver.close();
	}
}