package stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logs.Log;
import managers.FileReaderManager;
import pageObjects.LandingPage;
import resources.CommonFunctions;

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
		
		Log.startTestCase("signup test case");
		
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
		Log.endTestCase("signup test case");
	}

	
	
	@When("User perform login process with valid userName and password")
	public void user_perform_login_process_with_valid_user_name_and_password() throws InterruptedException {
	     
	 Log.startTestCase("login test case");
		
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
		Log.info("login test case");
	}
	
	
	
}
