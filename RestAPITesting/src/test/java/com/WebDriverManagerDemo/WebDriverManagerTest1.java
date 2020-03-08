package com.WebDriverManagerDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerTest1 {

	WebDriver driver;
	
	
	@BeforeMethod
	void setUp()
	{
		//WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver().version("80.0").arch64().setup();
		//WebDriverManager.chromedriver().version("80.0").arch64().proxy("proxy:80").proxyUser("user1").proxyPass("pwd12").setup();
		//driver=new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		
		
		/*WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.operadriver().setup();
		WebDriverManager.phantomjs().setup();
		WebDriverManager.edgedriver().setup();
		WebDriverManager.iedriver().setup();
		WebDriverManager.chromiumdriver().setup();*/		
		
	}
	
	
	@Test
	void launchApp()
	{
		driver.get("https://google.in");
		WebElement searchTextElement = driver.findElement(By.name("q"));
		searchTextElement.sendKeys("webdrivermanager");
		searchTextElement.sendKeys(Keys.ENTER);
	}
}
