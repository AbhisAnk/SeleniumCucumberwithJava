package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.FileReaderManager;
import pageObjects.LandingPage;
import resources.CommonFunctions;
import resources.Log;

public class LoginSteps {
	
	CommonFunctions commonFunctions;
	
	TestContext testContext;
	
	LandingPage landingPage;
	
	
	public LoginSteps(TestContext context) {
		
		testContext  = context;
		landingPage = testContext.getPageObjectManager().getlandingPage();
	}
	
	
	@Given("User navigates to application landing page")
	public void user_navigates_to_application_landing_page() {
		
		landingPage.navigateToApp(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
		
		
	@When("User perform signup process with valid userName and password")
	public void user_perform_signup_process_with_valid_user_name_and_password() {
		
		try {
			landingPage.doSignUP(FileReaderManager.getInstance().getConfigReader().getSignupUserName(), 
					FileReaderManager.getInstance().getConfigReader().getSingupPassword());
			
		} catch (InterruptedException e) {
			 
			e.printStackTrace();
		}
	    
	}

	 

	@Then("User should be signedup successfully")
	public void user_should_be_signedup_successfully() throws InterruptedException {
	     
		landingPage.signupVerification();
		
	}

	
	
	@When("User perform login process with valid userName and password")
	public void user_perform_login_process_with_valid_user_name_and_password() throws InterruptedException {
	     
		System.out.println(FileReaderManager.getInstance().getConfigReader().getLoginUserName()); 
		System.out.println(FileReaderManager.getInstance().getConfigReader().getLoginPassword());	
		
		try {
			landingPage.doLogin(FileReaderManager.getInstance().getConfigReader().getLoginUserName(), 
					FileReaderManager.getInstance().getConfigReader().getLoginPassword());
		}
		catch (Exception e) {
			
			Log.info("LoginProcess failed");
			CommonFunctions.takeSnapshot("login_alert");
			
			
		}
	
	}

	@Then("User should be loggedin successfully")
	public void user_should_be_loggedin_successfully() {

		landingPage.loginVerification(FileReaderManager.getInstance().getConfigReader().getLoginUserName());
		
	}
	
	
	
}
