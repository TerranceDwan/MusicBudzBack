package com.budz.selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class LoginUITests {
	public static WebDriver driver;
	
	@BeforeAll
	public static void init() {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://musicbudz.s3-website-us-east-1.amazonaws.com/login");
	}
	
	@Test
	@Disabled("until Selenium works w/Jenkins.")
	void test() {
		WebElement username = driver.findElement(By.id("login_username"));
		WebElement password = driver.findElement(By.id("login_password"));
		WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
		username.sendKeys("testUsername");
		password.sendKeys("testPass");
		submit.click();
		
		WebDriverWait w = new WebDriverWait(driver, 10);
		WebElement modal = w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#modal_container > .modal_wrapper")));
		
		Assertions.assertTrue(modal.isDisplayed());
	}
	
	@AfterAll
	public static void close() {
		driver.quit();
	}
}
