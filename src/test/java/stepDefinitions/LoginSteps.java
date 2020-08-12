package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.TestBase;

public class LoginSteps extends TestBase{
	
	@Given("Go to hosted page")
	public void go_to_hosted_page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		TestBase.OpenBrowser();	    
	}

	@When("Enter valid email and password")
	public void enter_valid_email_and_password() {
		
		LoginPage login=new LoginPage();
		login.credential("emai11l", "password");
	   
	}

	@And("Click login button")
	public void click_login_button() {
		LoginPage login=new LoginPage();
	    // Write code here that turns the phrase above into concrete actions
		login.clickLogin();
	}

	@Then("Dashboard should show")
	public void dashboard_should_show() {
	   
	}

}
