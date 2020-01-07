package test;

import java.io.File;
import java.util.Properties;

import org.apache.poi.poifs.crypt.Decryptor;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import com.google.common.base.Splitter.MapSplitter;
import org.openqa.selenium.TakesScreenshot;
import constants.Generic;
import functionslib.Functions;
import utils.XLutils;

public class Driver extends constants.Generic {
	
WebDriver driver;
	@Test
	public void test() throws Exception {
		Functions fn = new Functions();
		int msterrow = XLutils.getRow("MasterSheet");
		// Loop for master sheet
		for (int i = 1; i <= XLutils.getRow("MasterSheet"); i++) {

			String tobeTest = XLutils.getData("MasterSheet", i, 2);
			String moduleName = XLutils.getData("MasterSheet", i, 1);
			if (tobeTest.equalsIgnoreCase("y")) {
				// Loop for individual modules
				for (int j = 1; j <= XLutils.getRow(moduleName); j++) {

					String description = XLutils.getData(moduleName, j, 1);
					String testfunName = XLutils.getData(moduleName, j, 2);
					String attType = XLutils.getData(moduleName, j, 3);
					String attValue = XLutils.getData(moduleName, j, 4);
					String data = XLutils.getData(moduleName, j, 5);
					try {
						// Executing individual test steps
						if (testfunName.equalsIgnoreCase("startbrowser")) {
							driver = Generic.startBrowser();
					
						} else if (testfunName.equalsIgnoreCase("launchapp")) {
							Generic.launchApp();						

						} else if (testfunName.equalsIgnoreCase("waitForElement")) {
							fn.waitForElement(driver, attType, attValue, data);
							System.out.println("Wait for Element " + description);

						} else if (testfunName.equalsIgnoreCase("clickAction")) {//
							fn.clickAction(driver, attType, attValue);						

						} else if (testfunName.equalsIgnoreCase("typeAction")) {
							fn.typeAction(driver, attType, attValue, data);					
								

						} else if (testfunName.equalsIgnoreCase("captchClick")) {
							fn.captchClick(driver, attType, attValue);
				
						} else if (testfunName.equalsIgnoreCase("takeScreen")) {
							File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//
							FileUtils.copyFile(sc, new File(".\\screens\\"
									+ description + "_" + Functions.generateDate() + ".png"));
						
						}else if (testfunName.equalsIgnoreCase("closeBrowser")) {
							Generic.closeBrowser();			
						} 
						// updating the status of current test step
						XLutils.setData(moduleName, j, 6, "PASS");
						// if test fails this block executes
						// this block updates test status as FAIL and takes
						// screen shoot of the failed test Case
					} catch (Exception e) {
						XLutils.setData(moduleName, j, 6, "FAIL");
						File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//
						FileUtils.copyFile(sc, new File(".\\screens\\"
								+ description + "_" + Functions.generateDate() + ".png"));
						Functions.closeBrowser();
						XLutils.setData("MasterSheet", i, 3, "FAIL");
						break;
					}
					// updating the status of current Test Case as PASS
					XLutils.setData("MasterSheet", i, 3, "PASS");
				}
			}
		}
	}
}
