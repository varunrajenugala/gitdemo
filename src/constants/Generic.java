package constants;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.internal.PropertiesFile;
import utils.Properties;

public class Generic {

	static WebDriver driver;
//	code to initialize browser
	public static WebDriver startBrowser() throws Exception {
		// Getting browser information from .properties file
		String browser = Properties.getValue("browser");
		// setting the webdriver as per browser
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.geckodriver.driver",
					".\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please enter valid Browser name");
		}
		return driver;
	}
//  code to lunch application 
	public static void launchApp() throws Exception {
		String url=Properties.getValue("url");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		driver.close();
	}

}
