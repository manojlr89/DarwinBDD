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
	public static TestRunner runner=new TestRunner();
	
	public static void OpenBrowser() throws Exception {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("src/test/java/config/config.properties");	
		prop.load(fis);
	    
	    String browerName=prop.getProperty("browser");
		if (browerName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		   	 driver=new ChromeDriver();  		
	}
		else {		
			
			}
		if(runner.env.contains("dev")) {
			driver.manage().window().maximize();
			driver.get(prop.getProperty("devurl"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  	driver.findElement(By.id("loginradius-login-emailid"));
		  	String url = driver.getCurrentUrl();
			Assert.assertEquals(url, "https://demotesting.devhub.lrinternal.com/auth.aspx?return_url=https://dev-dashboard.lrinternal.com/login" );		
			
		}
		else if (runner.env.contains("stag")) {
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  	driver.findElement(By.id("loginradius-login-emailid"));
		  	String url = driver.getCurrentUrl();
			Assert.assertEquals(url, "https://accounts.loginradius.com/auth.aspx?return_url=https://adminconsole.loginradius.com/login" );		
			
		}
		else if (runner.env.contains("prod"))
		{
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  	driver.findElement(By.id("loginradius-login-emailid"));
		  	String url = driver.getCurrentUrl();
			Assert.assertEquals(url, "https://accounts.loginradius.com/auth.aspx?return_url=https://adminconsole.loginradius.com/login" );		
			
		}
		else {
			System.out.println("Check spelling or choose correct Environment");
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  	driver.findElement(By.id("loginradius-login-emailid"));
	  	String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://accounts.loginradius.com/auth.aspx?return_url=https://adminconsole.loginradius.com/login" );		
		
		
		
		
	}

}
