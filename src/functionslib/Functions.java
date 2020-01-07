package functionslib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.seleniumemulation.KeyEvent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Selection;

import constants.Generic;

public class Functions extends Generic {
	// code to click
	public void clickAction(WebDriver driver, String attType, String attValue) throws Exception {
		if (attType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attValue)).click();
		} else if (attType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(attValue)).click();
		} else if (attType.equalsIgnoreCase("class")) {
			driver.findElement(By.className(attValue)).click();
		} else if (attType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(attValue)).click();
		} else if (attType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector((attValue))).click();
		} else {
			throw new Exception();
		}
	}

	// code to wait for element explicitly wait
	public void waitForElement(WebDriver driver, String attType, String attValue, String data) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(data));
		if (attType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(attValue)));
		} else if (attType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id(attValue)));
		} else if (attType.equalsIgnoreCase("class")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.className(attValue)));
		} else if (attType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.name(attValue)));
		} else if (attType.equalsIgnoreCase("css")) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector((attValue))));
		} else {
			throw new Exception();
		}
	}

	// Code to Type text
	public void typeAction(WebDriver driver, String attType, String attValue, String data) throws Exception {

		if (attType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(attValue)).sendKeys(data);
		} else if (attType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(attValue)).sendKeys(data);
		} else if (attType.equalsIgnoreCase("class")) {
			driver.findElement(By.className(attValue)).sendKeys(data);
		} else if (attType.equalsIgnoreCase("name")) {
			driver.findElement(By.name(attValue)).sendKeys(data);
		} else if (attType.equalsIgnoreCase("css")) {
			driver.findElement(By.cssSelector((attValue))).sendKeys(data);
		} else {
			throw new Exception();
		}
	}

	// function  code to take screen shoot
	public static String generateDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MM_DD_SSS");
		return sdf.format(date);
	}
	
	// function code for captch click
	public static void captchClick(WebDriver driver, String attType, String attValue) throws Exception{
		
			if (attType.equalsIgnoreCase("xpath")) {
				driver.findElement(By.xpath(attValue)).sendKeys(Keys.ENTER);
			} else if (attType.equalsIgnoreCase("id")) {
				driver.findElement(By.id(attValue)).sendKeys(Keys.ENTER);
			} else if (attType.equalsIgnoreCase("class")) {
				driver.findElement(By.className(attValue)).sendKeys(Keys.ENTER);
			} else if (attType.equalsIgnoreCase("name")) {
				driver.findElement(By.name(attValue)).sendKeys(Keys.ENTER);
			} else if (attType.equalsIgnoreCase("css")) {
				driver.findElement(By.cssSelector((attValue))).sendKeys(Keys.ENTER);
			} else {
				throw new Exception();
			}
		//	FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		//	 wait.pollingEvery(5000,  TimeUnit.MILLISECONDS);
		}

	
	

}
