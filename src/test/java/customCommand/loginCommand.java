package customCommand;

import java.io.FileInputStream;
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
			FileInputStream free = new FileInputStream("src/test/java/config/dev.properties");
			prop.load(free);
			login.credential(prop.getProperty("free_dev_Email"), prop.getProperty("free_dev_Password"));
			login.clickLogin();
			break;
		case "dev":
			FileInputStream dev = new FileInputStream("src/test/java/config/dev.properties");
			prop.load(dev);
			login.credential(prop.getProperty("dev_dev_Email"), prop.getProperty("dev_dev_Password"));
			login.clickLogin();
			break;

		default:
			break;
		}	

	}

}
