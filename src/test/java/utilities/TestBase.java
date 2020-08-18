package utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

	@Parameters("browser")
	@BeforeMethod
	public static void OpenBrowser() throws Exception {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/test/java/config/env.properties");
		prop.load(fis);
		String browser = System.getProperty("browser");
		String env = System.getProperty("env");
		String url;
		if (browser == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else {
			switch (browser) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
		}
		if (env == null) {
			driver.manage().window().maximize();
			driver.get(prop.getProperty("devurl"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.id("loginradius-login-emailid"));
			url = driver.getCurrentUrl();
			Assert.assertEquals(url,
					"https://demotesting.devhub.lrinternal.com/auth.aspx?return_url=https://devadmin-console.lrinternal.com/login");
		} else {
			switch (env) {
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

	public static void Login() throws Exception {
		LoginPage login = new LoginPage();
		String plan = System.getProperty("plan");
		FileInputStream dev = new FileInputStream("src/test/java/config/dev.properties");
		prop.load(dev);
		if (plan == null) {
			// Running free plan user
			login.credential(prop.getProperty("free_dev_Email"), prop.getProperty("free_dev_Password"));
			login.clickLogin();
		} else {
			switch (plan) {
			case "dev": // Running dev plan user
				login.credential(prop.getProperty("dev_dev_Email"), prop.getProperty("dev_dev_Password"));
				login.clickLogin();
				break;
			case "devPremium":
				login.credential(prop.getProperty("dev_dev_Email"), prop.getProperty("dev_dev_Password"));
				login.clickLogin();
				break;
			}
		}
	}
}
