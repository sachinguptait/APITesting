package demoRelativeLocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RelativeLocatorsScenario2 {
	
	@Test
	public void testLoginApp()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		//driver.findElement(By.name("userName")).sendKeys("LearnAutomation");
		
		driver.findElement(RelativeLocator.withTagName("input").above(By.name("password")).
				below(By.xpath("//td//b[text()='sign-in here']"))).sendKeys("LearnAutomation");
		
		driver.findElement(By.name("password")).sendKeys("LearnAutomation@#");
		
		driver.findElement(RelativeLocator.withTagName("input").below(By.name("password"))).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Passengers:']")).isDisplayed());
		
	}

}
