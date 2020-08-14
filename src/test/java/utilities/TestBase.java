package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	public static void OpenBrowser() throws Exception {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/java/config/env.properties");
		prop.load(fis);
		String browser = System.getProperty("browser");
		String env = System.getProperty("env");
		// String browser1 = runner.browser;
		// String env = runner.env;
		String url;

		switch (browser) {
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}

		switch (env) {
		default:
			driver.manage().window().maximize();
			driver.get(prop.getProperty("devurl"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("loginradius-login-emailid"));
			url = driver.getCurrentUrl();
			Assert.assertEquals(url,
					"https://demotesting.devhub.lrinternal.com/auth.aspx?return_url=https://devadmin-console.lrinternal.com/login");
			break;
		case "stag":
			driver.manage().window().maximize();
			driver.get(prop.getProperty("stagurl"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("loginradius-login-emailid"));
			url = driver.getCurrentUrl();
			Assert.assertEquals(url,
					"https://stagingaccounts.lrinternal.com/auth.aspx?return_url=https://stagingadmin-console.lrinternal.com/login");
			break;
		}
	}
}
