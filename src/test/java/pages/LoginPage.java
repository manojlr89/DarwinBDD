package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id = "loginradius-login-emailid")
	WebElement txtEmail;
	@FindBy(id = "loginradius-login-password")
	WebElement txtPassword;
	@FindBy(id = "loginradius-submit-login")
	WebElement btnLogin;

	//WebDriver driver1;	
	//Initializing the page object
			//i initialize all web element	
			public LoginPage()
			{				
				//this.driver1=driver;
				
				PageFactory.initElements(driver, this);
			}

//	public void enterEmail(String email)
//	{
//		this.txtEmail.sendKeys(email);
//	}
	
	public void credential(String em,String pwd) {

		//driver.findElement(By.id("loginradius-login-emailid")).sendKeys(em);
		
		this.txtEmail.clear();
		this.txtEmail.sendKeys(em);
		this.txtPassword.clear();
		this.txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin() {
		btnLogin.click();		
	}

}
