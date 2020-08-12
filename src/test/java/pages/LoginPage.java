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

public class LoginPage extends TestBase {

	@FindBy(id = "loginradius-login-emailid")
	WebElement txtEmail;
	@FindBy(id = "loginradius-login-password")
	WebElement txtPassword;
	@FindBy(id = "loginradius-submit-login")
	WebElement btnLogin;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void credential(String em, String pwd) {
		this.txtEmail.clear();
		this.txtEmail.sendKeys(em);
		this.txtPassword.clear();
		this.txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

}
