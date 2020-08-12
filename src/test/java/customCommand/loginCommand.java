package customCommand;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;

import pages.LoginPage;
import testRunner.TestRunner;
import utilities.TestBase;

public class loginCommand extends TestBase {
	public static LoginPage login = new LoginPage();
	public static TestRunner runner = new TestRunner();
	static String plan = runner.plan;
	public static void Login() throws Exception {

		switch (plan) {

		case "free":
			login.credential(prop.getProperty("free_dev_Email"), prop.getProperty("free_dev_Password"));
			login.clickLogin();
			break;
		case "dev":
			login.credential(prop.getProperty("dev_dev_Email"), prop.getProperty("dev_dev_Password"));
			login.clickLogin();
			break;

		default:
			break;
		}
		
		
//		if (runner.env.contains("dev") && runner.plan.contains("free")) {
//				driver.manage().window().maximize();
//				driver.get(prop.getProperty("devurl"));
//				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//				driver.findElement(By.id("loginradius-login-emailid"));
//				String url = driver.getCurrentUrl();
//				Assert.assertEquals(url,
//						"https://demotesting.devhub.lrinternal.com/auth.aspx?return_url=https://devadmin-console.lrinternal.com/login");
//			login.credential(prop.getProperty("free_dev_Email"), prop.getProperty("free_dev_Password"));
//			login.clickLogin();
//
//		} else if (runner.env.contains("dev") && runner.plan.contains("dev")) {
//			driver.manage().window().maximize();
//			driver.get(prop.getProperty("devurl"));
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.findElement(By.id("loginradius-login-emailid"));
//			String url = driver.getCurrentUrl();
//			Assert.assertEquals(url,
//					"https://demotesting.devhub.lrinternal.com/auth.aspx?return_url=https://devadmin-console.lrinternal.com/login																																				");
//			login.credential(prop.getProperty("dev_dev_Email"), prop.getProperty("dev_dev_Password"));
//		}
//
//		else if (runner.env.contains("stag")) {
//			driver.manage().window().maximize();
//			driver.get(prop.getProperty("url"));
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.findElement(By.id("loginradius-login-emailid"));
//			String url = driver.getCurrentUrl();
//			Assert.assertEquals(url,
//					"https://accounts.loginradius.com/auth.aspx?return_url=https://adminconsole.loginradius.com/login");
//
//		} else if (runner.env.contains("prod")) {
//			driver.manage().window().maximize();
//			driver.get(prop.getProperty("url"));
//			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//			driver.findElement(By.id("loginradius-login-emailid"));
//			String url = driver.getCurrentUrl();
//			Assert.assertEquals(url,
//					"https://accounts.loginradius.com/auth.aspx?return_url=https://adminconsole.loginradius.com/login");
//
//		} else {
//			System.out.println("Check spelling or choose correct Environment");
//		}

	}

}
