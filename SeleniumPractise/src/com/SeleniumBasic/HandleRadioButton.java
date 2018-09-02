package com.SeleniumBasic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandleRadioButton {

	@Test
	public void radioButtonHandle() throws Exception {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium Latest\\DriverClass\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.keynotesupport.com/websites/contact-form-example-radio-buttons.shtml");

		List<WebElement> radiobtns = driver.findElements(By.xpath("//input[@type='radio']"));

		for (int i = 1; i < radiobtns.size(); i++) {
			WebElement radiobtn = radiobtns.get(i);

			boolean displayed = radiobtn.isDisplayed();
			System.out.println(i + "Radio Button Displayed?" + displayed);

			boolean enabled = radiobtn.isEnabled();
			System.out.println(i + "Radio Button Enabled?" + enabled);

			boolean selected = radiobtn.isSelected();
			System.out.println(i + "Radio Button Selected?" + selected);

			if (displayed == true && enabled == true && selected == false) {
				radiobtn.click();
				System.out.println(i + "Radio button Selected");
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@type='reset']"));
				Thread.sleep(3000);
				System.out.println("Radio Buttons Are Reset");

			}

		}
		driver.close();
	}
}