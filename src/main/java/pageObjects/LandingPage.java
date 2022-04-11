package pageObjects;

 
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
 
import org.testng.Assert;

import logs.Log;
import resources.CommonFunctions;



public class LandingPage {
	
	 WebDriver driver;
	 
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(how = How.ID, using = "login2")
	private WebElement loginLink;
	
	@FindBy(how = How.ID, using = "signin2")
	private WebElement signupLink;
	
	@FindBy(how = How.ID, using = "sign-username")
	private WebElement signusername;
	
	@FindBy(how =  How.ID, using = "sign-password")
	private WebElement signpassword;
	
	@FindBy(how =  How.XPATH, using = "//button[contains(text(),'Sign up')]")
	private WebElement signupButton;
	
	
	@FindBy(how = How.ID, using = "loginusername")
	private WebElement loginusername;
	
	@FindBy(how =  How.ID, using = "loginpassword")
	private WebElement loginpassword;
	
	@FindBy(how = How.ID, using = "nameofuser")
	private WebElement userID;
	
	
	@FindBy(how =  How.XPATH, using = "//button[contains(text(),'Log in')]")
	private WebElement loginButton;
	
 
	
	
	public void navigateToApp(String url)
	{
		
		driver.get(url);
		Log.info("navigated to appURL: "+url);
		
	}
	
	public void doSignUP (String userName, String password) throws InterruptedException {
		
		signupLink.click();
		Log.info("signupLink clicked");
		signusername.sendKeys(userName);
		Log.info("username given: "+userName);
		signpassword.sendKeys(password);
		Log.info("password given: "+password);
		signupButton.click();
		Log.info("signupButton clicked");
		Thread.sleep(1000);
		
		
	}
	
	public void signupVerification() throws InterruptedException {
		
		Thread.sleep(5000);
		
		String expectedAlertMessage = "Sign up successful.";
		Alert alert = driver.switchTo().alert();
		String actualAlertMessage = alert.getText();
		
		Log.info("Alert receieved.");
		//System.out.println("SignUp AlertMessage: "+actualAlertMessage);
		CommonFunctions.takeSnapshot("singup_AlertMessage");
		alert.accept();
		Assert.assertEquals(actualAlertMessage,expectedAlertMessage);
		
	}
	
	
	public void doLogin(String userName, String password) throws InterruptedException {
		
		loginLink.click();
		Log.info("login link clicked");
		loginusername.sendKeys(userName);
		Log.info("login username provided: "+userName);
		loginpassword.sendKeys(password);
		Log.info("login password provided: "+password);
		loginButton.click();
		Log.info("login button clicked.");
		Thread.sleep(5000);
		
	}
	
	
	public void loginVerification(String loginID) {
		
		String expectedUserID = "Welcome "+	loginID;
		String acutalUserID = userID.getText();
		
		Assert.assertEquals(expectedUserID, acutalUserID);
		//System.out.println("Login successful");
		
		
		
	}
	

}
