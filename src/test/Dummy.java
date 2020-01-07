package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dummy {
	@Test
	public void test() throws Exception{
		
		// i personally created from testing individually
		
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://app.aumnics.com/signup");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@id='rc-anchor-container']//span[1]")).click();
//		driver.findElement(By.cssSelector("#recaptcha-anchor")).isSelected();		
	}

}
