package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import testRunner.TestRunner;

public class TestBase {	
	public static WebDriver driver;
	public static Properties prop;
	public static TestRunner runner = new TestRunner();

	public static void OpenBrowser() throws Exception {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/java/config/config.properties");
		prop.load(fis);
		String browser = runner.browser;
		String env = runner.env;
		String url;
		switch (browser) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			break;
		}
		switch (env) {

		case "dev":
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

		default:
			break;
		}

	}

}
