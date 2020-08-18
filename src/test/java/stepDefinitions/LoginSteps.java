package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.TestBase;

public class LoginSteps extends TestBase {
	@Test
	@Given("Go to hosted page")
	public void go_to_hosted_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		TestBase.OpenBrowser();
	}

	@When("Enter valid email and password")
	public void enter_valid_email_and_password() throws Exception {
		// LoginPage login=new LoginPage();
		TestBase.Login();

	}

	@And("Click login button")
	public void click_login_button() throws Exception {
		String url;
		// loginCommand.Login();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("loginradius-login-emailid"));
		url = driver.getCurrentUrl();
		Assert.assertEquals(url,
				"https://demotesting.devhub.lrinternal.com/auth.aspx?return_url=https://devadmin-console.lrinternal.com/login");
	}

	@Then("Dashboard should show")
	public void dashboard_should_show() {

	}

}
