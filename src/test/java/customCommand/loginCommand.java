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

	public static void Login() throws Exception {
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
