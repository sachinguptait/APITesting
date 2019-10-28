package demoRelativeLocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAppWithRelativeLocators {
	
	@Test
	public void testRegisterLink()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		
		//driver.findElement(RelativeLocator.withTagName("a").toRightOf(By.linkText("SIGN-ON"))).click();
		
		driver.findElement(RelativeLocator.withTagName("a").toLeftOf(By.linkText("SUPPORT")).toRightOf(By.linkText("SIGN-ON"))).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//b[text()='Email:']")).isDisplayed());
	}

}
